/*
 *   Copyright © 2018-2021 PSPDFKit GmbH. All rights reserved.
 *
 *   The PSPDFKit Sample applications are licensed with a modified BSD license.
 *   Please see License for details. This notice may not be removed from this file.
 */

package com.pspdfkit.example.customfonts

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pspdfkit.PSPDFKit
import com.pspdfkit.configuration.activity.PdfActivityConfiguration
import com.pspdfkit.ui.PdfActivity
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.io.File

/**
 * This is the launcher activity of the Custom Fonts example for PSPDFKit for Android.
 */
class CustomFontsActivity : AppCompatActivity() {
    /** List of custom fonts. These refer to files inside the app's assets/ folder. */
    private val customFonts = listOf("Meddon.ttf", "NunitoSans-SemiBold.ttf")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Name of an app-private folder that holds the custom fonts. In the next step, we'll ensure
        // that all custom fonts are extracted to this folder.
        val customFontsFolder = getDir("custom-fonts2", Context.MODE_PRIVATE)

        extractFontFiles(customFonts, customFontsFolder)
            .subscribeOn(Schedulers.io())
            .doOnComplete { initializeWithFonts(customFontsFolder) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::showDocument)
    }

    /**
     * This method initializes PSPDFKit using the pre-configured license string, providing a path to custom fonts
     * for PSPDFKit to use.
     */
    private fun initializeWithFonts(customFontsFolder: File) {
        val licenseString = resources.getString(R.string.pspdfkit_license_key)
        val fontPaths = listOf(customFontsFolder.absolutePath)
        PSPDFKit.initialize(this, licenseString, fontPaths)
    }

    /**
     * Shows the example document that is inside the app's assets/ folder. This PDF uses custom fonts that are not
     * part of the Android operating system (and aren't embedded into the PDF either). PSPDFKit will use the
     * previously defined font include path to search for the fonts used by the PDF.
     */
    private fun showDocument() {
        val config = PdfActivityConfiguration.Builder(this).build()
        val uri = Uri.parse("file:///android_asset/Example-Fonts.pdf")
        PdfActivity.showDocument(this, uri, config)
    }
}

/**
 * This method extracts all custom font files that ship with this example to a private folder on the file system,
 * which is necessary for PSPDFKit to access the fonts. Extraction can be performed in the background, but has to
 * be complete before PSPDFKit is initialized.
 */
private fun Context.extractFontFiles(fontAssets: List<String>, targetFolder: File) = Completable.fromAction {
    if (!targetFolder.exists()) targetFolder.mkdirs()
    fontAssets.forEach { assetFile ->
        val outputFile = targetFolder.resolve(assetFile)
        if (!outputFile.exists()) {
            outputFile.outputStream().use { output ->
                resources.assets.open(assetFile).use { input ->
                    input.copyTo(output)
                }
            }
        }
    }
}
