gamemode @s spectator
tellraw @a ["",{"selector":"@s"},{"text":" died","color":"red"},{"text":"!"}]

tp @s @a[scores={killer=1..},limit=1]

