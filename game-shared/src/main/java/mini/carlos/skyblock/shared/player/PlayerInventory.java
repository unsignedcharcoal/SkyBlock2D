package mini.carlos.skyblock.shared.player;

import mini.carlos.skyblock.shared.item.Item;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class PlayerInventory {

    private final Map<InventoryArmorSlot, Item> armorContents;
    private final Map<InventoryFingerSlot, Item> fingerContents;

    private final BitSet lockedInventorySlots;
    private final List<Item> inventoryContents;

    public PlayerInventory(int size) {
        this.inventoryContents = new ArrayList<>(Collections.nCopies(size, null));
        this.lockedInventorySlots = new BitSet(size);

        this.armorContents = new ConcurrentHashMap<>();
        this.fingerContents = new ConcurrentHashMap<>();
    }

    public boolean addItem(int index, Item item) {
        if (isSlotLocked(index)) return false;
        if (inventoryContents.get(index) != null) return false;

        inventoryContents.set(index, item);
        return true;
    }

    public void addArmor(InventoryArmorSlot slot, Item item) {
        armorContents.put(slot, item);
    }

    public void addFinger(InventoryFingerSlot slot, Item item) {
        fingerContents.put(slot, item);
    }

    public Item removeArmor(InventoryArmorSlot slot) {
        return armorContents.remove(slot);
    }

    public Item removeFinger(InventoryFingerSlot slot) {
        return fingerContents.remove(slot);
    }

    public Item getArmor(InventoryArmorSlot slot) {
        return armorContents.get(slot);
    }

    public Item getFinger(InventoryFingerSlot slot) {
        return fingerContents.get(slot);
    }

    public Item swapArmor(InventoryArmorSlot slot, Item newItem) {
        return armorContents.put(slot, newItem); // retorna o anterior
    }

    public boolean hasArmor(InventoryArmorSlot slot) {
        return armorContents.containsKey(slot);
    }

    public boolean hasFinger(InventoryFingerSlot slot) {
        return fingerContents.containsKey(slot);
    }

    public void lockSlot(int index) {
        lockedInventorySlots.set(index);
    }

    public void unlockSlot(int index) {
        lockedInventorySlots.clear(index);
    }

    public boolean isSlotLocked(int index) {
        return lockedInventorySlots.get(index);
    }

    public boolean addItemToAvailableSlot(Item item) {
        for (int i = 0; i < inventoryContents.size(); i++) {
            if (!isSlotLocked(i) && inventoryContents.get(i) == null) {
                inventoryContents.set(i, item);
                return true;
            }
        }
        return false; // inventário cheio ou trancado
    }

    public int getUnlockedSlotCount() {
        int count = 0;
        for (int i = 0; i < inventoryContents.size(); i++) {
            if (!isSlotLocked(i)) count++;
        }
        return count;
    }

    public List<Integer> getLockedSlotIndexes() {
        List<Integer> list = new ArrayList<>();
        for (int i = lockedInventorySlots.nextSetBit(0); i >= 0; i = lockedInventorySlots.nextSetBit(i+1)) {
            list.add(i);
        }
        return list;
    }

}
