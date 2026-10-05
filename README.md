# Hollowsong

Mod about: turning vibrations into a survival resource. Capture echoes, build resonant circuits, and use sound instead of redstone. Version: 1.0.0 | MC: 1.21.11 | Fabric | Java: 25 | Loom: 1.18-SNAPSHOT
Blocks: ringstone_ore, ringstone_block | Items: ringstone
Note: textures are placeholder PNGs (need real art)

---

## 1. Overview

Minecraft already has a hidden physics system almost nobody builds with: **vibrations**. Sculk sensors detect them and wardens hunt by them, but for most players it is a novelty.

**Hollowsong turns sound into a first-class survival resource.** Every footstep, piston, and explosion leaves a fading "echo" in the blocks around it, and players can **capture, store, move, and weaponize** those echoes.

The fantasy stays vanilla: you notice deep slate "humming" near a strange chamber, find resonant crystals that ring as you walk past, and realize you can tune a cave like an instrument.

- No mana, no spellcasting, no classes.
- Just a new material property (**resonance**), a new tool (**tuning**), and a lot of emergent engineering.

---

## 2. Main Gameplay Loop

1. **Hear**: Early on, the player notices ambient hums in caves and Ringstone ore that chimes when mined. Craft a **Tuning Fork** to "read" the resonance stored in blocks.
2. **Harvest**: Collect **Echo Shards** (from resonance chambers and deep-slate veins), mine **Ringstone**, and *record* sounds (a creeper explosion, a note block melody, a door slam).
3. **Compose**: Build resonant circuits. Vibration relays carry signals wirelessly through stone, chimes redirect mob pathfinding, and dampeners let you sneak past wardens *or* silence your own base.
4. **Engineer**: Build tuned systems in the mid-to-late game: automated mob farms driven by sound lures instead of water, alarm networks with no redstone dust, and player-operated "sonar" for cave mapping.
5. **Master**: Find the rare **Grand Caverns**, solve their acoustic puzzle rooms, and assemble a **Resonant Core** to unlock the endgame.

---

## 3. New Blocks

| Block | Function |
| --- | --- |
| **Ringstone Ore** (deep slate, y < 0) | Drops Ringstone. Chimes when a player walks within 4 blocks; the first breadcrumb that the system exists. |
| **Ringstone Block** | Emits a soft tone when powered, with note-block-style pitch control via right-click. Building material with a note-block texture palette (slabs, stairs, walls). |
| **Resonant Crystal** | Grows in small clusters in resonance chambers. Stores one "recording" (any vibration event within 8 blocks). Emits it faintly on loop until re-tuned. Breaks into 1-2 Echo Shards. |
| **Echo Shards** (item/block) | The sound analogue of redstone dust. Carry a recording. Place in a Chime Array to play it. |
| **Vibration Relay** | Receives a vibration (or a recorded echo fed in via shard) and re-emits it 16 blocks in one facing direction through solid stone. Line of sight is not required, but each relay adds slight delay and attenuation. **Max chain: 8 relays** before the signal dies. |
| **Dampener Wool** (16 colors + greyscale) | Wool variant that *absorbs* vibrations in a radius instead of just muffling them to sculk sensors. Black dampeners give 100% absorption in a 3-block radius. Expensive: wool + echo shard. |
| **Resonance Comparator** | Like a comparator, but reads the *intensity* of the nearest vibration source rather than container fullness. Enables analog sound logic. |
| **Chime Array** | A 3x3 multi-block "speaker." Plays stored echoes at configurable volume/pitch. Mobs react, and players within earshot hear the sound as if at its origin. |
| **Listening Post** | A tripod block. Sneak-right-click to sample the biome's ambient sound profile and produce a **Sound Map**. |
| **Tuning Table** | Workstation and village "Acoustician" profession block. Combine shards, tune crystals, and deconstruct recordings into "pure tones." |

---

## 4. New Items

| Item | Details |
| --- | --- |
| **Tuning Fork** | Iron + Ringstone. Right-click a block to show (as a brief particle ring) how much residual resonance it holds. Right-click air to emit a standard ping. Durability-less, like shears. |
| **Sound Map** | A map that renders *noise sources* as colored fog blips instead of terrain (chests that clicked, mobs that groaned, players that sprinted) within **64 blocks**, fading over **30 seconds**. Made at a Listening Post with a map + echo shard. The mod's signature tool: sonar for caves and for hunting other players. |
| **Echo Shard (recorded)** | Holds a specific sound. Sneak + right-click a Resonant Crystal to extract. Insert into relays, chimes, or the Resonant Core. |
| **Muffling Boots** | Boots-slot armor. Iron boots + black dampener wool. Halves the vibration radius of your own movement. Costs armor toughness. Anti-warden tech. |
| **Lure Whistle** | Plays a stored mob sound once (e.g., a cow's moo), attracting mobs of that type within **32 blocks** toward the whistle-blower for **10 seconds**. Aggressive mobs are attracted *but not pacified*, so a zombie-groan whistle is a gamble. One use per shard; reusable whistle frame. |
| **Hummer Wings** | Brewing ingredient, farmed from Hummers. |
| **Tinted Echo Shards** | Drop from echo-tinted mobs and carry their sounds. |
| **Silent Shard** | Blank recording; pure null-vibration. Dropped by the Hush. Used for endgame. |
| **Disc Fragment: Hymn** | Music disc fragment found in resonance chambers (occasionally) and Grand Cavern vaults. |

---

## 5. New Mobs

### Hummers
- Small, passive, blind, cave-dwelling moth-like mobs.
- Spawn near resonant crystals.
- Hover toward the **loudest** vibration source in range, acting as a natural pointer to hidden chambers.
- Breedable with glow berries; farmable for **Hummer Wings**.

### The Hush
- Not a boss you fight. A rare, dormant **warden variant** that spawns in Grand Caverns if players make too much noise.
- Immune to damage while "listening" (stationary, pulsing).
- Its sweep attack is a cone of force that **throws** you rather than dealing raw damage.
- **Defeat it by silence:** trigger no vibrations for **20 seconds** while it wanders. It burrows away and drops a **Silent Shard**.
- Loud bases can attract wandering Hushes (surface raids at night if a chime farm is too loud).

### Echo-tinted variants
- Vanilla mobs (creepers, skeletons) that spawn in resonance chambers with a subtle visual filter.
- Drop **Tinted Echo Shards** carrying their sounds.
- Drop **2x XP**, giving players a reason to hunt specific mobs in specific places.

---

## 6. New Structures

| Structure | Details |
| --- | --- |
| **Resonance Chambers** | Medium-sized geode-like rooms in deep slate layers (rare, 1 per 3-5 eligible chunks). Contain crystals, ringstone seams, and a loot chest with echo shards and occasionally a **Disc Fragment: Hymn**. Sometimes rigged with a Hush. |
| **Grand Caverns** | Large, rare cave complexes (comparable in rarity to Ancient Cities, but smaller) with multi-room acoustic puzzles. Examples: a chamber where you play the correct three-note sequence (clued by the echo of your own footsteps off tuned walls) to open a vault; a "silent corridor" guarded by a Hush. The vault holds the **Resonant Core blueprint** and the Hymn disc. |
| **Pilgrim Camps** | Rare surface camps where an **Acoustician** villager spawns with trades (echo shards, dampener wool, sound maps). Sits alongside 26.3's Abandoned Camps as a "living" counterpart. |

---

## 7. Core Mechanics

1. **Residual Resonance**: Every vibration event deposits a tiny amount of resonance in nearby resonant-capable blocks (ringstone, crystals, deepslate bricks). The Tuning Fork reads it, so caves feel alive and exploration is rewarded ("this cavern rang with an explosion recently... someone was here").
2. **Recording & Playback**: Crystals record, shards carry, chimes and relays play. Any in-game sound event is recordable. This is the engine for everything else.
3. **Mob Sonotaxis**: Mobs pathfind toward sounds they "like": animals to feed sounds, monsters to player sounds (already partially vanilla), and *each species to its own call*. Players can exploit or weaponize this.
4. **Silence as State**: A player standing on dampener wool and wearing muffling boots produces near-zero vibration. Wardens can't hear you and the Hush can't find you. Certain Grand Cavern doors only open for players with a zero-vibration profile.

---

## 8. Progression System

No XP grind. Progression is **tooling and knowledge**, mirroring vanilla's (find iron, then diamonds, then netherite).

| Tier | Name | Unlocks |
| --- | --- | --- |
| 1 | **Listener** | Ringstone + Tuning Fork. Read resonance, craft chimes. |
| 2 | **Composer** | Echo shards + Vibration Relays + Dampener Wool. Record sounds, build signal networks, sneak past wardens. |
| 3 | **Engineer** | Resonance Comparators, Chime Arrays, Lure Whistles, Sound Maps. Full analog sound logic and mob manipulation. |
| 4 | **Master** | Silent Shard + Resonant Core. Endgame. |

Grand Caverns gate Tier 4 behind the Hush encounter, which in turn requires mastery of silence mechanics. To unlock the loudest power, the player must first learn to make no sound at all.

---

## 9. Crafting Recipes (key items)

```
Tuning Fork:          Iron Ingot | Iron Ingot | Ringstone  (vertical, fork shape)
Ringstone Block:      9 Ringstone
Vibration Relay:      Deepslate Bricks | Echo Shard | Copper Ingot
Dampener Wool:        Wool (any) + Echo Shard (shapeless, 1 wool -> 1 dampener wool)
Resonance Comparator: Ringstone Block | Quartz | Ringstone Block  (comparator shape)
Chime Array:          9 Ringstone Blocks (3x3) -> place as multi-block
Listening Post:       2 Copper Ingots + Ringstone + Tripwire Hook
Muffling Boots:       Iron Boots + 4 Black Dampener Wool (surrounding)
Lure Whistle:         Copper Ingot + Echo Shard
Sound Map:            Map + Echo Shard at a Listening Post (UI crafting)
Resonant Core:        4 Resonant Crystals + Silent Shard + 4 Ringstone Blocks
                      (must also be "activated" inside a Grand Cavern vault)
```

---

## 10. How It Fits Survival Mode

- Everything is earned through play: mine ringstone on diamond trips, loot chambers while already caving, and fight (or out-silence) the Hush when endgame-ready.
- Nothing replaces vanilla loops; it *rewards* them.
- Caving becomes information-rich, mob farms gain a new design axis, and wardens become a puzzle instead of a damage sponge.
- The Sound Map slots into 26.3's explorer-map overhaul as a new map type.

---

## 11. Potential by Playstyle

- **Exploration:** Resonance Chambers and Grand Caverns as dungeon-delve targets; Sound Map as cave sonar; Hummers as living treasure compasses.
- **Combat:** Lure whistles as traps (groan-lure a horde into a pit *or* into another player's base); dampeners for warden raids; Chime Arrays as area denial (a loud ping briefly interrupts skeletons' aim, a stun rather than damage).
- **Building:** Ringstone as a full chime-instrument building set; hidden doors keyed to specific sound sequences (your base's "doorbell melody" is a password); acoustic interiors that actually *do* something.
- **Automation:** Vibration relays act as wireless redstone through stone with attenuation tradeoffs; Resonance Comparators enable analog logic on mob-farm crowding (reads mob sounds per second); lure whistles pull mobs through waterless collection lanes. Every design has a cost (shard consumption, chain limits, noise attracting trouble), so it complements rather than replaces redstone.

---

## 12. Balance Considerations

- **Attenuation:** Every relay hop weakens the signal; the 8-hop maximum forces physical infrastructure and prevents infinite wireless.
- **Consumables:** Recorded shards are single-use in whistles and maps. Echo shard drop rates are tuned so a farm yields **1 shard per minute**: useful, never free.
- **Counterplay:** Your own noise economy matters. Loud bases attract wandering Hushes. The PvP counter to Sound Maps is dampener wool interiors and muffling boots.
- **No direct damage:** The mod's "weapons" are information, redirection, and brief interrupts. Nothing out-DPSs a diamond sword; everything out-*thinks* it.
- **Warden respect:** Silence tools let you bypass wardens, but Silent Shards are Hush-gated, so that power is earned post-midgame.

---

## 13. Multiplayer Features

- **Sound Maps reveal players:** Sprinting, mining, and TNT all blip on enemy maps, so bases must be *acoustically designed*. Server-configurable: map blips can be team-only.
- **Acoustic warfare:** Chime spam masks your own raid team's movement; lure whistles redirect a patrol; dampener rooms act as intel dead zones.
- **Grand Cavern races:** Caverns regenerate loot per player instance (like trial chambers), so multiple players can run the same cavern fairly.
- **Shared songbooks:** Recorded melody shards can be traded like written books: player-composed door passwords, base anthems, map-wide concert events.
- **Acoustician trading:** A real economy around shards, with server-tunable prices.

---

## 14. Endgame Content

### The Resonant Core
A placeable block that, once activated in a Grand Cavern vault, becomes a **renewable (slow) source of pure-tone shards** and grants the **Conductor** ability:

- While holding a tuning fork, any recorded echo in your inventory can be played at your location at will: effectively a personal, curated spellbook of *sounds* (not damage).
- Examples: a creeper hiss to scatter animals into pens; a village bell to make villagers *panic-sprint* to safety; an ender pearl land-sound as a fake-out in PvP.

### Hymn of the Hollow
A 2-minute music disc, only assembleable from disc fragments found in Grand Cavern vaults. A cosmetic flex.

### Tune the World
The true endgame goal: a hidden achievement for recording every vanilla sound category at least once. Grants a cape-style cosmetic (modded, client-side only) and a title.

---

## 15. Advancements

| Advancement | Condition |
| --- | --- |
| *What's That Ringing?* | Mine your first Ringstone |
| *Hush Now* | Walk within 5 blocks of a warden while producing zero vibration |
| *Wiretap* | Read another player's residual resonance |
| *Orchestra Pit* | Power 16 chime blocks simultaneously |
| *Lullaby* | Put a Hush back to sleep |
| *Pipe Down* | Trigger a raid on another player's base using only a lure whistle |
| *Concerto Grosso* | Activate a Resonant Core |
| *Tune the World* | Record all sound categories (challenge advancement) |

---

## 16. Technical Overview

**Difficulty: Medium**

- All block, item, entity, recipe, and worldgen content uses standard, well-trodden loader APIs.
- **Vibration hooks:** The mod reads the existing game-event system (sculk sensor events are already a registry), so recording is *interception*, not new physics.
- **The three genuinely hard parts** (each bounded):
  1. The **Sound Map renderer** (custom map layer, like vanilla biome/structure maps)
  2. **Mob sonotaxis** pathfinding hooks (Goal injection)
  3. The **Hush's silence-detection state machine**
- **Estimated effort:** one experienced developer could ship a vertical slice in about a month and a full release in 3-4 months.

### Build setup (decided)
- **Minecraft:** Java Edition 26.3
- **Loader:** Fabric first (NeoForge possible later)
- **Java:** JDK 25
- **Build:** Gradle wrapper from the Fabric template (not a system Gradle)
- **Template options:** split client/common sources and data generation enabled; Kotlin disabled

---

## 17. Why Players Keep Using It After Hour 10

Resonance becomes a **lens on the whole game**, not a content island. Every vanilla action you already take (walking, mining, breeding, fighting) now has an acoustic footprint you can read, hide, or exploit.

- **Builders** get a functional instrument blockset and puzzle doors.
- **Redstoners** get a wireless-signal design space with attenuation math to optimize.
- **Explorers** get sonar and living cave dungeons.
- **PvPers** get information warfare.
- The recording system is inherently *creative*: players will compose doorbell passwords, fake raid sirens, cow-pen lullabies, and Disc Fragment hunts with friends. These are things the mod author never designed, which is exactly the test of a good Minecraft mod.