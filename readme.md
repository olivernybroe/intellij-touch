# IntelliJ Touch Bar

This plugin adds support for the MacBook Touch bar in IntelliJ IDE's.

The plugin is waiting for approval so right now you will have to install it manually.


## Features

- Customizable
- MacBook Pro Touch Bar
- Uses IntelliJ's structure for setup

## Manual install
- Download latest release
- Go to `Preferences` -> `Plugins` -> `Install plugin from disk...` and select the file.
- Restart your IDE and you are good to go!


## Configuration
For setting up the touch bar, go to `Appearance & Behavior` -> `Menus and Toolbars`. \
There Should now be a new menu called `Touch Bar`, from here you can just add items to the menu like you normally would.

It could for example be like this

![settings](https://raw.githubusercontent.com/olivernybre/intellij-touch/master/docs/settings.png)

Which would generate the following

![example](https://raw.githubusercontent.com/olivernybre/intellij-touch/master/docs/example.png)


## Built with

- [JTouchBar](https://github.com/Thizzer/JTouchBar) - Java library for using the touchbar API on supported macbooks.
