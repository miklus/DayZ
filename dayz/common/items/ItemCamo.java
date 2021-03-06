package dayz.common.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;
import dayz.DayZ;
import dayz.common.misc.Util;

public class ItemCamo extends ItemArmor implements IArmorTextureProvider
{
    /** Holds the 'base' maxDamage that each armorType have. */
    private static final int[] maxDamageArray = new int[] {11, 16, 15, 13};

    /**
     * Stores the armor type: 0 is helmet, 1 is plate, 2 is legs and 3 is boots
     */
    public final int armorType;

    /** Holds the amount of damage that the armor reduces at full durability. */
    public final int damageReduceAmount;

    /**
     * Used on RenderPlayer to select the correspondent armor to be rendered on the player: 0 is cloth, 1 is chain, 2 is
     * iron, 3 is diamond and 4 is gold.
     */
    public final int renderIndex;

    /** The EnumArmorMaterial used for this ItemArmor */
    private final EnumArmorMaterial material;
    
    private int textureIndex;

    public ItemCamo(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4)
    {
        super(par1, par2EnumArmorMaterial, par4, par4);
        this.material = par2EnumArmorMaterial;
        this.armorType = par4;
        this.textureIndex = par4;
        this.renderIndex = par3;
        this.damageReduceAmount = par2EnumArmorMaterial.getDamageReductionAmount(par4);
        this.setMaxDamage(par2EnumArmorMaterial.getDurability(par4));
        this.maxStackSize = 1;
        this.setCreativeTab(DayZ.creativeTabDayZ);
    }

    public void registerIcons(IconRegister par1IconRegister)
    {
    	switch(this.armorType)
    	{
    	case 0: this.itemIcon = par1IconRegister.registerIcon(Util.ID + ":CamoHead"); return;
    	case 1: this.itemIcon = par1IconRegister.registerIcon(Util.ID + ":CamoChest"); return;
    	case 2: this.itemIcon = par1IconRegister.registerIcon(Util.ID + ":CamoLegs"); return;
    	case 3: this.itemIcon = par1IconRegister.registerIcon(Util.ID + ":CamoFeet"); return;
    	}
    }

    @Override
    public String getArmorTextureFile(ItemStack itemstack)
    {
        if (itemstack.itemID == DayZ.camohelmet.itemID || itemstack.itemID == DayZ.camochest.itemID || itemstack.itemID == DayZ.camoboots.itemID)
        {
            return "/dayz/images/armor/camo_1.png";
        }

        if (itemstack.itemID == DayZ.camolegs.itemID)
        {
            return "/dayz/images/armor/camo_2.png";
        }

        return "/dayz/images/armor/camo_2.png";
    }
}