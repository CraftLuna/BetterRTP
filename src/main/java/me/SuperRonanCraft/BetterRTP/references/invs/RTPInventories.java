package me.SuperRonanCraft.BetterRTP.references.invs;

import me.SuperRonanCraft.BetterRTP.references.invs.enums.RTPInventory_Defaults;
import me.SuperRonanCraft.BetterRTP.BetterRTP;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class RTPInventories {

    private final HashMap<RTP_INV_SETTINGS, RTPInventory_Defaults> invs = new HashMap<>();

    public void load() {
        invs.clear();
        for (RTP_INV_SETTINGS type : RTP_INV_SETTINGS.values()) {
            type.load(type);
            invs.put(type, type.getInv());
        }
    }

    public void closeAll() {
        BetterRTP main = BetterRTP.getInstance();
        for (Player p : Bukkit.getOnlinePlayers())
            if (main.getPInfo().playerExists(p)) {
                main.getPInfo().clearInvs(p);
                p.closeInventory();
            }
    }

    public RTPInventory_Defaults getInv(RTP_INV_SETTINGS type) {
        return invs.get(type);
    }
}