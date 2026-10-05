# Hollowsong — Development Roadmap

> A sound-resonance expansion mod for Minecraft 1.21.11 (Fabric, Java 25).
> This file is the single source of truth for development progress.
> Design document: see project README / design doc (Hollowsong spec).
> Tick boxes as work completes. Commit with the milestone name.

**Locked decisions**
- Scope: full design document (Tiers 1–4). No release until complete.
- Platform: Fabric only. No NeoForge port planned.
- Assets: self-made (Blockbench/Piskel) + CC0 (Freesound.org), converted to OGG.
- No public alpha/beta builds. First public release = v1.0.

---

## Status legend

`[x]` done · `[~]` partial · `[ ]` not started

---

## Current state — pre-M0

- [x] Ringstone Ore (texture, loot table, hidden `resonance` property 0–4)
- [x] Ringstone Block (texture, model)
- [x] Ringstone item (drops from ore)
- [x] Tuning Fork (custom ping sound, random pitch, cooldown, particle ring)
- [x] Tuning Fork reads resonance from Ringstone Ore (pitch + particle scale)
- [x] Proximity charging (walking near ore builds resonance; sneaking does not)
- [ ] Resonance decay (resonance never fades — STAND-IN, fix in M0)
- [ ] Ringstone Block powered chime + right-click pitch (doc §3)
- [x] GitHub repo with CI

---

## M0 — Slice polish

Goal: make the existing stand-in mechanics honest.

- [ ] Resonance decay: e.g. every 60 s without charging, resonance −1 (fading echo, doc §7.1)
- [ ] Charge rate tuned (currently ~20%/s per nearby block — too fast; target minutes, not seconds)
- [ ] All M0 features pass the F3 test script (see "QA standard" below)
- [ ] Commit: `M0: resonance decay and balance`

## M1 — True Listener (Tier 1)

Goal: replace proximity stand-in with real vibrations; finish Tier 1.

- [ ] Game-event hook: explosions, block breaks, piston extends near ore deposit resonance (doc §7.1: "every footstep, piston, and explosion leaves a fading echo")
- [ ] Ringstone Block: emits tone while powered; right-click sets pitch like a note block (doc §3)
- [ ] Advancement: *"What's That Ringing?"* — mine your first Ringstone (doc §15)
- [ ] Decide + document: game-event interception method (vibration listener vs. Fabric event proxies)
- [ ] Test script: TNT near ore → fork reads rising resonance; powered ringstone block chimes
- [ ] Commit: `M1: true Listener tier`

## M2 — Recording Engine (Tier 2 core) ⚠️ the mod's heart

Goal: record → store → replay. Everything after consumes this.

- [ ] Resonant Crystal block: records a game event within 8 blocks (doc §3)
- [ ] Crystal emits recording faintly on loop until re-tuned
- [ ] Echo Shard item: extract recording from crystal (sneak + right-click, doc §4)
- [ ] Recording storage: custom data component on the shard (1.21.5+ way, NOT NBT)
- [ ] Vibration Relay: re-emits recording 16 blocks through stone, attenuation per hop, max 8-chain (doc §3)
- [ ] Migrate recipes/loot/models to Fabric data generation (entrypoint exists)
- [ ] Assets sprint: crystal texture/model, shard texture, relay texture
- [ ] Test script: record a door slam → extract shard → relay it through a wall → hear it on the far side
- [ ] Commit: `M2: recording engine`

## M3 — Composer (Tier 2)

Goal: playback networks + silence tech.

- [ ] Chime Array (3×3 multiblock "speaker"): plays stored echoes, volume/pitch config (doc §3)
- [ ] Dampener Wool: absorbs vibrations in radius; black = full absorption r=3 (doc §3)
- [ ] Muffling Boots: iron boots + black dampener wool; halve own vibration radius (doc §4)
- [ ] Warden stealth verified: dampeners + boots + sneaking = pass a warden in test world (doc §7.4)
- [ ] Advancement: *"Hush Now"* — walk within 5 blocks of a warden at zero vibration (doc §15)
- [ ] Assets sprint: wool textures (start with 1 greyscale + black; full 16 colors is stretch), boots model
- [ ] Test script: full silence profile = zero vibration; loud base triggers nothing yet (that's M6)
- [ ] Commit: `M3: Composer tier`

## M4 — Caves come alive (structures + mobs)

Goal: the world generates Hollowsong content.

- [ ] Resonance Chambers: geode-like rooms in deepslate (rare), crystals + ringstone seams + loot chest, occasional Disc Fragment (doc §6)
- [ ] Hummers: passive blind cave moths; hover toward loudest vibration; breed with glow berries; drop Hummer Wings (doc §5)
- [ ] Echo-tinted variants: creepers/skeletons in chambers drop Tinted Echo Shards + 2× XP (doc §5)
- [ ] Echo Shard (recorded) drops from tinted mobs
- [ ] Advancement: *"Wiretap"* — read another player's residual resonance (MP test, doc §15)
- [ ] Assets sprint: hummer model/texture/sounds, chamber deco blocks
- [ ] Test script: `/locate` a chamber; hummer leads you to hidden crystal
- [ ] Commit: `M4: resonance chambers and hummers`

## M5 — Engineer (Tier 3)

Goal: analog sound logic + mob manipulation.

- [ ] Resonance Comparator: outputs signal strength from nearest vibration intensity (doc §3)
- [ ] Lure Whistle: plays stored mob call; attracts that species 32 blocks / 10 s; aggro not pacified (doc §4)
- [ ] Sound Map: map item rendering noise sources as fading blips, 64-block range, 30 s fade (doc §4) — ⚠️ hardest render task, prototype first
- [ ] Listening Post: sample biome ambient profile (doc §3)
- [ ] Advancements: *"Orchestra Pit"* (16 chimes), *"Pipe Down"* (raid via whistle) (doc §15)
- [ ] Assets sprint: map UI, comparator, whistle, post
- [ ] Test script: mob farm crowding reads on comparator; whistle pulls a cow into a pen
- [ ] Commit: `M5: Engineer tier`

## M6 — Endgame (Tier 4)

Goal: the Hush, the Core, the Hymn.

- [ ] The Hush: dormant warden variant for Grand Caverns; immune while listening; throw attack; defeated by 20 s of silence; drops Silent Shard; loud bases attract night raids (doc §5)
- [ ] Grand Caverns: rare multi-room acoustic puzzle complexes; vault holds Core blueprint + Hymn disc (doc §6)
- [ ] Pilgrim Camps: surface camps with Acoustician villager + trades (doc §6)
- [ ] Resonant Core: activated in vault; slow pure-tone shard source + Conductor ability (play any recorded echo at will) (doc §14)
- [ ] Hymn of the Hollow: assembleable 2-min music disc from fragments (doc §14)
- [ ] Advancements: *"Lullaby"*, *"Concerto Grosso"*, challenge: *"Tune the World"* — record every sound category (doc §15)
- [ ] Server config file: all balance values from doc §12 (charge rates, relay range, map team mode)
- [ ] Assets sprint: hush model/sounds, core, disc, camp structures
- [ ] Test script: survive a Hush by going silent; activate a Core; play a creeper hiss from inventory
- [ ] Commit: `M6: endgame`

---

## Release — v1.0 (after M6)

- [ ] Full playthrough on survival server (multiplayer features verified)
- [ ] Modrinth + CurseForge page (description, gallery, CC0 asset attribution list)
- [ ] License review: CC BY-NC-ND 4.0 — confirm platform terms compatibility
- [ ] GitHub release tagged `v1.0.0`

---

## Asset checklist (running total)

### Sounds (~18, OGG, self-made/Freesound CC0)
- [x] `tuning_fork_ping` (5 s ring, random pitch 0.9–1.1)
- [ ] crystal record/loop · chime array playback · relay pulse · dampener absorb · comparator tick · listening post sample · whistle blow (×5 species variants?) · hummer flutter/ambient · hush listen/sweep/burrow/heartbeat · core hum · conductor echo play · hymn fragments → disc

### Textures/models
- [x] ringstone_ore · ringstone_block · ringstone · tuning_fork · icon
- [ ] crystal · shard · relay · dampener wool (greyscale+black first) · comparator · chime array · listening post · tuning table · sound map · boots · whistle · wings · tinted shards · silent shard · disc fragment · hummer · hush · core (+ chime block variants slabs/stairs/walls as stretch)

## QA standard (every milestone)

Each milestone ships only after its **test script passes in-game**, checked via F3 debug + logs, e.g.:
- F3 shows `resonance` value changing as designed
- `run\logs\latest.log` has zero hollowsong WARN/ERROR lines
- Multiplayer-sensitive features tested on integrated server with 2+ players (or LAN)

## Project conventions (hard-won 1.21.11 rules)

1. Every item: `.registryKey(...)` in Settings BEFORE construction (else `Item id not set`)
2. Every block: `.lootTable(...)`/key set in Settings (else `Block id not set`)
3. Every item needs `assets/hollowsong/items/<id>.json` (1.21.4+ inventory definitions)
4. Plain cube blocks = hand-written 5-line JSON; Blockbench exports only for real 3D shapes
5. Registries live in `Registries`, registry KEYS in `RegistryKeys`
6. Files: lowercase ASCII names only; JSON saved UTF-8 **without BOM** (VS Code status bar)
7. Textures: 8-bit RGBA PNG; sounds: OGG Vorbis
8. New `ModX` registry class ⇒ add `ModX.registerModX()` to `onInitialize()` (miss = mid-game crash, not compile error)
9. Static fields construct items/blocks at class-load time only via the registration helpers
10. Commit at every green test; push at every milestone
