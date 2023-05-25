clear @a
gamemode survival @a
kill @a

tellraw @a ["",{"text":"Start of the game.","color":"gray"},{"text":" Good luck!","color":"yellow"}]
tellraw @a ["",{"text":"Killer:","color":"red"},{"text":" "},{"selector":"@a[scores={killer=1}]"},{"text":"\n"},{"text":"Heros:","color":"dark_green"},{"text":" "},{"selector":"@a[scores={killer=0}]"}]

