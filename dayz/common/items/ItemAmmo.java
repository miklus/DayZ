package dayz.common.items;

import dayz.common.misc.Util;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemAmmo extends Item
{
	private int textureIndex;
    public ItemAmmo(int i, int j)
    {
        super(i);
        textureIndex = j;
        maxStackSize = 1;
    }

    public void registerIcons(IconRegister par1IconRegister)
    {
    	switch(this.textureIndex)
    	{
    		case 0:	this.itemIcon = par1IconRegister.registerIcon(Util.ID + ":akmag");
    		case 1: this.itemIcon = par1IconRegister.registerIcon(Util.ID + ":MakarovMag");
    		case 2: this.itemIcon = par1IconRegister.registerIcon(Util.ID + ":akmag");
    		case 3: this.itemIcon = par1IconRegister.registerIcon(Util.ID + ":LeeMag");
    		case 4: this.itemIcon = par1IconRegister.registerIcon(Util.ID + ":akmag");
    		case 5: this.itemIcon = par1IconRegister.registerIcon(Util.ID + ":akmag");
    		default: this.itemIcon = par1IconRegister.registerIcon(Util.ID + ":akmag");
    	}
    }
}
