<div align="center">
    <hr/>
        <h1 align="center" style="border-bottom: none">Ogmios Java Client Library</h1>
    <hr/>
</div>

## What is Ogmios?
**Ogmios** is a lightweight bridge interface for [Cardano Node](https://github.com/input-output-hk/cardano-node/). It offers a **WebSocket API** that enables local clients to speak [Ouroboros' mini-protocols](https://hydra.iohk.io/build/1070091/download/1/network.pdf#chapter.3) via **JSON/RPC**.

## Features
- Synchronous messaging using java objects
- Transaction submission with enhanced error messages
- Structured Java Objects logging
- Full ledger state query support:
  - [ ] blockHeight
  - [ ] chainTip
  - [ ] currentEpoch
  - [ ] currentProtocolParameters
  - [ ] delegationsAndRewards
  - [ ] eraStart
  - [ ] eraSummaries
  - [x] genesisConfig (protocolParameters)
  - [x] ledgerTip
  - [ ] nonMyopicMemberRewards
  - [ ] poolIds
  - [ ] poolParameters
  - [ ] poolsRanking
  - [ ] proposedProtocolParameters
  - [ ] rewardsProvenance
  - [ ] stakeDistribution
  - [ ] systemStart
  - [x] utxoByAddress

<hr/>
<div align="center">

[![License](https://img.shields.io/badge/License-Apache_2.0-yellowgreen.svg)](https://opensource.org/licenses/Apache-2.0)
</div>

[//]: # (<p align="center">)

[//]: # (  <a href="https://cardanosolutions.github.io/ogmios">:book: User Manual</a>)

[//]: # (  |)

[//]: # (  <a href="CONTRIBUTING.md">:triangular_ruler: Contributing</a>)

[//]: # (  |)

[//]: # (  <a href="SPONSORS.md">:gift_heart: Sponsors</a>)

[//]: # (  |)

[//]: # (  <a href="CHANGELOG.md">:floppy_disk: Changelog</a>)

[//]: # (</p>)