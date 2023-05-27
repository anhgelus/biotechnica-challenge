execute as @a unless score @s killer matches 0..1 run scoreboard players set @s killer 0

execute as @a[scores={death=1..,killer=1}] run function biotechnica-life:killer/revive
execute as @a[scores={death=1..,killer=0}] run function biotechnica-life:heros/kill

execute unless entity @a[nbt={Inventory:[{id:"playertrackingcompass:tracking_compass"}]},scores={killer=1}] as @a[scores={killer=1}] run give @s playertrackingcompass:tracking_compass

clear @a[scores={killer=0}] playertrackingcompass:tracking_compass

