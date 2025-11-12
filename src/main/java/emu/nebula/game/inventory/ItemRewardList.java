package emu.nebula.game.inventory;

import java.util.ArrayList;

public class ItemRewardList extends ArrayList<ItemRewardParam> {
    private static final long serialVersionUID = -4317949564663392685L;

    public ItemRewardList() {
        super();
    }
    
    public ItemParamMap generateRewards() {
        var map = new ItemParamMap();
        
        for (var param : this) {
            map.add(param.getId(), param.getRandomCount());
        }
        
        return map;
    }
}