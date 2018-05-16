[![JetBrains plugins](https://img.shields.io/jetbrains/plugin/d/10608-intellij-touch.svg)](https://plugins.jetbrains.com/plugin/10608-intellij-touch)
![GitHub stars](https://img.shields.io/github/stars/olivernybroe/intellij-touch.svg?label=Stars)
![Jetbrains rating](https://img.shields.io/badge/dynamic/json.svg?label=JetBrains%20rating&url=https%3A%2F%2Fplugins.jetbrains.com%2Fplugin%2FgetPluginInfo%3FpluginId%3D10608&query=%24.totalRating&suffix=/5)
[![JetBrains Plugins](https://img.shields.io/jetbrains/plugin/v/10608-intellij-touch.svg)](https://plugins.jetbrains.com/plugin/10608-intellij-touch)


# IntelliJ Touch Bar
![cover](https://github.com/olivernybroe/intellij-touch/raw/master/docs/cover.png)

This plugin has been deprecated. IntelliJ now has support for the Touch bar with the most of our features. No further development will be made, instead we recommend you to update to IntelliJ 2018.2 for Touch bar support. If you would like to contribute, then do it directly to IntelliJ instead.

This plugin adds support for the MacBook Touch bar in IntelliJ IDE's.

Right now the plugin does not support automatic update of settings, so you have two ways of updating the touch bar

- Restart the IDE
- Go to `Appearance & Behavior` -> `Menus and Toolbars` -> `Touch Bar` and press the button.

## Features

- Customizable
- MacBook Pro Touch Bar
- Uses IntelliJ's structure for setup

## Automatic install 
The plugin can be found here on [Intellij's plugin page](https://plugins.jetbrains.com/plugin/10608-intellij-touch).
- Go To `Preferences` -> `Plugins` -> `Browse repositories...`
- Search for `intellij-touch` and install
- Restart the IDE and you are up and running!

## Manual install
- Download latest release from [release page](https://github.com/olivernybroe/intellij-touch/releases).
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
