package cyanthundermc.cyansmod.inventory;

import cyanthundermc.cyansmod.tileentities.TileEntityBox;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerBox extends Container {

    protected TileEntityBox tileEntity;

    int containerRows;
    int containerCols;

    private static final int containerBoxCols = 9;
    private static final int containerBoxRows = 5;

    public static final int containerSize = containerBoxCols * containerBoxRows;

    public ContainerBox (InventoryPlayer inventoryPlayer, TileEntityBox tileEntityBox){
        tileEntity = tileEntityBox;
        tileEntity.openInventory();

        containerRows = containerBoxRows;
        containerCols = containerBoxRows;

        for (int rowIndex = 0; rowIndex < containerRows; rowIndex++) {
            for (int colIndex = 0; colIndex < containerCols; colIndex++) {
                addSlotToContainer(new Slot(tileEntityBox, colIndex + rowIndex * containerRows, 8 + colIndex * 18, 18 + rowIndex * 18 - 22));
            }
        }

        bindPlayerInventory(inventoryPlayer);
    }

    @Override
    public void onContainerClosed(EntityPlayer player) {
        super.onContainerClosed(player);
        tileEntity.closeInventory();
    }

    protected void bindPlayerInventory(InventoryPlayer playerInventory) {
        int xSize = 176;
        int ySize = 214 - 24;
        int leftCol = (xSize - 162) / 2 + 1;
        for (int playerInvRow = 0; playerInvRow < 3; playerInvRow++)
        {
            for (int playerInvCol = 0; playerInvCol < 9; playerInvCol++)
            {
                addSlotToContainer(new Slot(playerInventory, playerInvCol + playerInvRow * 9 + 9, leftCol + playerInvCol * 18, ySize - (4 - playerInvRow) * 18
                        - 10));
            }

        }

        for (int hotbarSlot = 0; hotbarSlot < 9; hotbarSlot++)
        {
            addSlotToContainer(new Slot(playerInventory, hotbarSlot, leftCol + hotbarSlot * 18, ySize - 24));
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int s) {
        ItemStack stack = null;
        Slot slot = (Slot) inventorySlots.get(s);
        if (slot != null && slot.getHasStack())
        {
            ItemStack itemStack = slot.getStack();
            stack = itemStack.copy();

            if (s < containerRows * containerCols)
            {
                if (!this.mergeItemStack(itemStack, containerRows * containerCols, inventorySlots.size(), false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemStack, 0, containerRows * containerCols, false))
            {
                return null;
            }

            if (itemStack.stackSize == 0)
            {
                slot.putStack(null);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return stack;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tileEntity.isUseableByPlayer(player);
    }
}
