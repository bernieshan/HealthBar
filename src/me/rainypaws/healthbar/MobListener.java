package me.rainypaws.healthbar;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;

import java.util.HashMap;

public class MobListener implements Listener {
//    private boolean enabled = false;
//
//    public void setMobListenerEnabled(boolean bool) {
//        enabled = bool;
//    }

    private static final HashMap<EntityType, String> entities = new HashMap<>();
    static {
        entities.put(EntityType.BEE, "Bee");
        entities.put(EntityType.CAVE_SPIDER, "Cave Spider");
        entities.put(EntityType.DOLPHIN, "Dolphin");
        entities.put(EntityType.ENDERMAN, "Enderman");
        entities.put(EntityType.IRON_GOLEM, "Iron Golem");
        entities.put(EntityType.LLAMA, "Llama");
        entities.put(EntityType.PANDA, "Panda");
        entities.put(EntityType.PIGLIN, "Piglin");
        entities.put(EntityType.POLAR_BEAR, "Polar Bear");
        entities.put(EntityType.PUFFERFISH, "Pufferfish");
        entities.put(EntityType.SPIDER, "Spider");
        entities.put(EntityType.WOLF, "Wolf");
        entities.put(EntityType.ZOMBIFIED_PIGLIN, "Zombified Piglin");
        entities.put(EntityType.BLAZE, "Blaze");
        entities.put(EntityType.CREEPER, "Creeper");
        entities.put(EntityType.DROWNED, "Drowned");
        entities.put(EntityType.ELDER_GUARDIAN, "Elder Guardian");
        entities.put(EntityType.ENDERMITE, "Endermite");
        entities.put(EntityType.EVOKER, "Evoker");
        entities.put(EntityType.GHAST, "Ghast");
        entities.put(EntityType.GUARDIAN, "Guardian");
        entities.put(EntityType.HOGLIN, "Hoglin");
        entities.put(EntityType.HUSK, "Husk");
        entities.put(EntityType.MAGMA_CUBE, "Magma Cube");
        entities.put(EntityType.PHANTOM, "Phantom");
        entities.put(EntityType.PILLAGER, "Pillager");
        entities.put(EntityType.RAVAGER, "Ravager");
        entities.put(EntityType.SHULKER, "Shulker");
        entities.put(EntityType.SILVERFISH, "Silverfish");
        entities.put(EntityType.SKELETON, "Skeleton");
        entities.put(EntityType.SKELETON_HORSE, "Skeleton Horse");
        entities.put(EntityType.SLIME, "Slime");
        entities.put(EntityType.STRAY, "Stray");
        entities.put(EntityType.VEX, "Vex");
        entities.put(EntityType.VINDICATOR, "Vindicator");
        entities.put(EntityType.WITCH, "Witch");
        entities.put(EntityType.WITHER_SKELETON, "Wither Skeleton");
        entities.put(EntityType.ZOGLIN, "Zoglin");
        entities.put(EntityType.ZOMBIE, "Zombie");
        entities.put(EntityType.ZOMBIE_VILLAGER, "Zombie Villager");
        entities.put(EntityType.BAT, "Bat");
        entities.put(EntityType.CAT, "Cat");
        entities.put(EntityType.CHICKEN, "Chicken");
        entities.put(EntityType.COD, "Cod");
        entities.put(EntityType.COW, "Cow");
        entities.put(EntityType.DONKEY, "Donkey");
        entities.put(EntityType.FOX, "Fox");
        entities.put(EntityType.HORSE, "Horse");
        entities.put(EntityType.MUSHROOM_COW, "Mooshroom Cow");
        entities.put(EntityType.MULE, "Mule");
        entities.put(EntityType.OCELOT, "Ocelot");
        entities.put(EntityType.PARROT, "Parrot");
        entities.put(EntityType.PIG, "Pig");
        entities.put(EntityType.RABBIT, "Rabbit");
        entities.put(EntityType.SALMON, "Salmon");
        entities.put(EntityType.SHEEP, "Sheep");
        entities.put(EntityType.SNOWMAN, "Snowman");
        entities.put(EntityType.SQUID, "Squid");
        entities.put(EntityType.STRIDER, "Strider");
        entities.put(EntityType.TROPICAL_FISH, "Tropical Fish");
        entities.put(EntityType.TURTLE, "Turtle");
        entities.put(EntityType.VILLAGER, "Villager");
        entities.put(EntityType.WANDERING_TRADER, "Wandering Trader");
    }

    @EventHandler
    @SuppressWarnings("deprecation")
    public void onMobSpawn(EntitySpawnEvent event) {
        if (entities.containsKey(event.getEntityType())) {
            LivingEntity mob = (LivingEntity) event.getEntity();
            int health = (int) mob.getHealth();
            int maxHealth = (int) mob.getMaxHealth();
            event.getEntity().setCustomName(ChatColor.RED + entities.get(event.getEntityType()) + " " + ChatColor.GREEN +
                    health + ChatColor.WHITE + "/" + ChatColor.GREEN + maxHealth + ChatColor.RED + "❤");
        }
    }

    @EventHandler
    @SuppressWarnings("deprecation")
    public void onMobDamage(EntityDamageEvent event) {
        if (entities.containsKey(event.getEntityType())) {
            LivingEntity mob = (LivingEntity) event.getEntity();
            int damage = (int) event.getDamage();
            int health = (int) mob.getHealth() - damage;
            int maxHealth = (int) mob.getMaxHealth();
            if (health < 0.5 * maxHealth) {
                if (health <= 0) {
                    event.getEntity().setCustomName(ChatColor.RED + entities.get(event.getEntityType()) + " " + ChatColor.YELLOW +
                            0 + ChatColor.WHITE + "/" + ChatColor.GREEN + maxHealth + ChatColor.RED + "❤");
                    return;
                }
                event.getEntity().setCustomName(ChatColor.RED + entities.get(event.getEntityType()) + " " + ChatColor.YELLOW +
                        health + ChatColor.WHITE + "/" + ChatColor.GREEN + maxHealth + ChatColor.RED + "❤");
                return;
            }
            event.getEntity().setCustomName(ChatColor.RED + entities.get(event.getEntityType()) + " " + ChatColor.GREEN +
                    health + ChatColor.WHITE + "/" + ChatColor.GREEN + maxHealth + ChatColor.RED + "❤");
        }
    }
}
