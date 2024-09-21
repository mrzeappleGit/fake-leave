# FakeLeave Plugin

## Overview
**FakeLeave** is a Minecraft plugin designed to allow players to fake their leave and rejoin events. This plugin broadcasts custom messages when a player "leaves" or "joins," making them invisible and changing their game mode as configured. Perfect for servers that want to administrators trying to catch bad actors in the act.

## Features
- Broadcasts fake leave and join messages to all players.
- Allows a player to become invisible when "leaving."
- Switches the player's gamemode when "leaving" or "joining" (configurable).
- Allows permissions-based control over commands.
- Configuration reload command.

## Installation

1. Download the latest version of the plugin jar file.
2. Place the plugin file in the `plugins` folder of your Minecraft server.
3. Restart or reload the server.

## Commands

| Command  | Description                  | Permission             |
| -------- | ---------------------------- | ---------------------- |
| `/faleave` | Broadcasts a fake leave message, makes the player invisible, and changes the gamemode if configured. | `canPrefromCommand`     |
| `/fajoin`  | Broadcasts a fake join message, removes invisibility, and changes the gamemode back. | `canPrefromCommand`     |
| `/faload`  | Reloads the plugin configuration. | `canPrefromCommand`     |

## Permissions
The plugin uses a single permission:

- `canPrefromCommand` – Grants access to the commands in this plugin.

## Configuration

You can customize various aspects of the plugin by modifying the `config.yml` file.

```yaml
# The color of the leave message
color: "RED"

# The leave message to broadcast
leave_message: "has left the game."

# Automatically change gamemode to Creative on leave
gamemode: "true"

# The color of the join message
join_color: "GREEN"

# The join message to broadcast
join_message: "has joined the game."

# Automatically change gamemode to Survival on join
gamemode_join: "true"
