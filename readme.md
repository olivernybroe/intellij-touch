# IntelliJ Touch Bar
![cover](https://github.com/olivernybroe/intellij-touch/raw/master/docs/cover.png)


This plugin adds support for the MacBook Touch bar in IntelliJ IDE's.

The plugin is waiting for approval so right now you will have to install it manually.

Right now the plugin does not support automatic update of settings and requires a restart of the IDE before the changes takes affect.

## Features

- Customizable
- MacBook Pro Touch Bar
- Uses IntelliJ's structure for setup

## Automatic install (Waiting approval)
- Go To `Preferences` -> `Plugins` -> `Browse repositories...`
- Search for `intellij-touch` and install
- Restart the IDE and you are up and running!

## Manual install
- Download latest release
- Go to `Preferences` -> `Plugins` -> `Install plugin from disk...` and select the file.
- Restart your IDE and you are good to go!


## Configuration
For setting up the touch bar, go to `Appearance & Behavior` -> `Menus and Toolbars`. \
There Should now be a new menu called `Touch Bar`, from here you can just add items to the menu like you normally would.

It could for example be like this

![settings](https://github.com/olivernybroe/intellij-touch/raw/master/docs/settings.png)

Which would generate the following

![example](https://github.com/olivernybroe/intellij-touch/raw/master/docs/example.png)


## Built with

- [JTouchBar](https://github.com/Thizzer/JTouchBar) - Java library for using the touchbar API on supported macbooks. Thanks @Thizzer
