/*
 *   Copyright © 2018-2024 PSPDFKit GmbH. All rights reserved.
 *
 *   The PSPDFKit Sample applications are licensed with a modified BSD license.
 *   Please see License for details. This notice may not be removed from this file.
 */

package com.pspdfkit.example.customfonts

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pspdfkit.configuration.activity.PdfActivityConfiguration
import com.pspdfkit.initialization.InitializationProvider
import com.pspdfkit.ui.PdfActivity

/**
 * This is the launcher activity of the Custom Fonts example for PSPDFKit for Android.
 *
 * 2021-12-21 updated by michael kellner
 * Custom font intitialization is now handled by the [InitializationProvider] with according configuration
 * in the manifest (see meta-data "pspdfkit_font_path" in the manifest)
 */
class CustomFontsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showDocument()
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
