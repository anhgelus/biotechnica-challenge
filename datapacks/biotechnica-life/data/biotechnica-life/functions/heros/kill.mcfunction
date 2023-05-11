gamemode spectator @s 
tellraw @a ["",{"selector":"@s"},{"text":"is dead","color":"red"},{"text":" forever!"}]

tp @s @a[scores={killer=1..},limit=1]

scoreboard players set @s death 0

