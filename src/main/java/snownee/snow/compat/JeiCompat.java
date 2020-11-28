package snownee.snow.compat;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.ingredients.IIngredientType;
import mezz.jei.api.runtime.IIngredientManager;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import snownee.snow.MainModule;
import snownee.snow.SnowRealMagic;

@JeiPlugin
public class JeiCompat implements IModPlugin {

    public static final ResourceLocation UID = new ResourceLocation(SnowRealMagic.MODID, "main");

    @Override
    public ResourceLocation getPluginUid() {
        return UID;
    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
        IIngredientManager manager = jeiRuntime.getIngredientManager();
        IIngredientType<ItemStack> type = manager.getIngredientType(ItemStack.class);
        Collection<ItemStack> collection = Arrays.asList(MainModule.FENCE, MainModule.FENCE2, MainModule.FENCE_GATE, MainModule.SLAB, MainModule.STAIRS, MainModule.WALL).stream().map(ItemStack::new).collect(Collectors.toList());
        manager.removeIngredientsAtRuntime(type, collection);
    }

}
