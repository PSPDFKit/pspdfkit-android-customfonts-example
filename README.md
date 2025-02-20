# PSPDFKit for Android - Custom Fonts Example

This is the custom fonts example of [PSPDFKit for Android](https://pspdfkit.com/pdf-sdk/android/). This example shows how to ship custom font files with an app so that they can be used in situations where PDF documents require custom fonts that are not part of the Android operating system. This example is written in Kotlin, but all functions also apply to PSPDFKit when using Java or any other compatible programming language.

## Prerequisites

- The latest stable Android Studio version available [here](https://developer.android.com/studio).

## Getting Started

Clone and check out the custom fonts example repository on your local machine:

```sh
git clone https://github.com/PSPDFKit/pspdfkit-android-custom-fonts-example.git
cd pspdfkit-android-custom-fonts-example
```

You can now open the project inside Android Studio, or build and install the app directly from the command line:

```sh
./gradlew :installDebug
```

## Example Description

### Structure

**assets/**: The assets folder of the app (`app/src/main/assets/`) contain a custom PDF file called `Example-Fonts.pdf`. This PDF references fonts that are not part of the default system fonts of the Android operating system.

Furthermore, the assets folder contains two custom TrueType font files, which will be added to PSPDFKit's font include path, so that PSPDFKit will be able to properly render the example document.
  
**`CustomFontsActivity`**: This app comes with a single activity class which, upon launched, prepares the custom fonts for usage, and then launches a default `PdfActivity` for displaying the document with custom fonts.

### Disabling automatic initialization

This example project does not specify the `pspdfkit_license_key` as `meta-data` element inside the `AndroidManifest.xml`. This is intentional, and prevents PSPDFKit from automatically initializing without custom fonts. Instead, custom font loading requires the app to manually initialize PSPDFKit using `PSPDFKit.initialize(context, InitializationOptions(licenseKey, fontPaths))`.

## License

This software is licensed under a [modified BSD license](LICENSE).

## Additional Resources

* PSPDFKit for Android online guides: https://pspdfkit.com/guides/android/current/
* PSPDFKit API reference:
  * KDoc: https://pspdfkit.com/api/android/kdoc/
  * Javadoc: https://pspdfkit.com/api/android/javadoc/
* PSPDFKit technical customer support: https://pspdfkit.com/support/request/  
