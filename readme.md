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

> Works best with actions from `Main Menu` as they often contains icons.

It could for example be like this

![settings](https://github.com/olivernybroe/intellij-touch/raw/master/docs/settings.png)

Which would generate the following

![example](https://github.com/olivernybroe/intellij-touch/raw/master/docs/example.png)


## Plugin developers
If you have a plugin and would like to add support for the touch bar, you can do it easily by adding custom actions in your own actionGroup.

Remember to add icons!

![plugin_devs](https://github.com/olivernybroe/intellij-touch/raw/master/docs/plugin_devs.png)


## Built with

- [JTouchBar](https://github.com/Thizzer/JTouchBar) - Java library for using the touchbar API on supported macbooks. Thanks @Thizzer
