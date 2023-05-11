execute as @a unless score @s killer matches 0..1 run scoreboard players set @s killer 0

execute as @a[scores={death=1..,killer=1}] run function biotechnica-life:killer/revive
execute as @a[scores={death=1..,killer=0}] run function biotechnica-life:heros/kill

