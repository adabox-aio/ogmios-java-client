<div align="center">
    <hr/>
        <h1 align="center" style="border-bottom: none">Ogmios Java Client</h1>

[![License](https://img.shields.io/badge/License-Apache_2.0-yellowgreen.svg)](https://opensource.org/licenses/Apache-2.0)
    <hr/>
</div>

## What is Ogmios?
**Ogmios** Java Client Library is based on [Ogmios](https://github.com/CardanoSolutions/ogmios) JSON/RPC lightweight bridge interface for [Cardano Node](https://github.com/input-output-hk/cardano-node/) by [Matthias Benkort](https://github.com/KtorZ). <br>
It offers a **WebSocket API** that enables local clients to speak [Ouroboros' mini-protocols](https://hydra.iohk.io/build/1070091/download/1/network.pdf#chapter.3) via **JSON/RPC**.

## Overview
**Ogmios Java Client** is a java library that can be used to convert Java Objects into their **Ogmios** Requests **JSON/RPC** representation. It can also be used to convert **Ogmios JSON/RPC** Responses to their equivalent Java objects. <br>
The Java library allows synchronous communication with **Ogmios** Server by interacting with a Websocket client connection using a timeout parameter. <br>

## Features
- Synchronous messaging using java objects
- Transaction submission with enhanced error messages
- Structured Java Objects logging
- Full ledger state query support:
  - [ ] blockHeight
  - [ ] chainTip
  - [x] currentEpoch
  - [x] currentProtocolParameters
  - [ ] delegationsAndRewards
  - [ ] eraStart
  - [ ] eraSummaries
  - [x] genesisConfig
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

</div>

<p align="center">
<a href="CONTRIBUTING.md">:triangular_ruler: Contributing</a>
  |
<a href="SPONSORS.md">:gift_heart: Sponsors</a>

[//]: # (  <a href="https://cardanosolutions.github.io/ogmios">:book: User Manual</a>)

[//]: # (  <a href="CHANGELOG.md">:floppy_disk: Changelog</a>)
</p>