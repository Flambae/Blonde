package emu.nebula.game.instance;

import java.util.List;

import emu.nebula.game.inventory.ItemParamMap;
import emu.nebula.game.inventory.ItemRewardParam;
import emu.nebula.game.player.Player;

public interface InstanceData {
    
    public int getId();
    
    public int getNeedWorldClass();
    
    public int getEnergyConsume();
    
    // Handle reward generation
    
    public List<ItemRewardParam> getFirstRewards();
    
    public default List<ItemRewardParam> getFirstRewards(int rewardType) {
        return getFirstRewards();
    }
    
    public default ItemParamMap generateFirstRewards(int rewardType) {
        return this.generateRewards(this.getFirstRewards());
    }
    
    public List<ItemRewardParam> getRewards();
    
    public default List<ItemRewardParam> getRewards(int rewardType) {
        return getRewards();
    }
    
    public default ItemParamMap generateRewards(int rewardType) {
        return this.generateRewards(this.getRewards());
    }
    
    public default ItemParamMap generateRewards(List<ItemRewardParam> params) {
        var map = new ItemParamMap();
        
        for (var param : params) {
            map.add(param.getId(), param.getRandomCount());
        }
        
        return map;
    }
    
    /**
     * Checks if the player has enough energy to complete this instance
     * @return true if the player has enough energy
     */
    public default boolean hasEnergy(Player player) {
        return this.hasEnergy(player, 1);
    }
    
    /**
     * Checks if the player has enough energy to complete this instance
     * @return true if the player has enough energy
     */
    public default boolean hasEnergy(Player player, int count) {
        return (this.getEnergyConsume() * count) <= player.getEnergy();
    }
    
}
