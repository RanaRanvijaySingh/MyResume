fastlane documentation
================
# Installation

Make sure you have the latest version of the Xcode command line tools installed:

```
xcode-select --install
```

Install _fastlane_ using
```
[sudo] gem install fastlane -NV
```
or alternatively using `brew cask install fastlane`

# Available Actions
## Android
### android beta
```
fastlane android beta
```
Deploy a new version to the Google Play - BETA
### android qa
```
fastlane android qa
```
Deploy a new for QA
### android cleanBuild
```
fastlane android cleanBuild
```
Clean project
### android unitTestDebug
```
fastlane android unitTestDebug
```

### android uiTest
```
fastlane android uiTest
```

### android createDebug
```
fastlane android createDebug
```
Create debug build
### android createRelease
```
fastlane android createRelease
```
Create release build
### android pushToBeta
```
fastlane android pushToBeta
```
Push apk to beta, skip uploading metadata, images and screenshots.

----

This README.md is auto-generated and will be re-generated every time [fastlane](https://fastlane.tools) is run.
More information about fastlane can be found on [fastlane.tools](https://fastlane.tools).
The documentation of fastlane can be found on [docs.fastlane.tools](https://docs.fastlane.tools).
