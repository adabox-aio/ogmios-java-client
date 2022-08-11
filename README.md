<div style="text-align: center">
    <hr/>
        <h1 style="border-bottom: none; text-align: center">Ogmios Java Client</h1>

[![Build](https://github.com/adabox-aio/ogmios-java-client/actions/workflows/maven.yml/badge.svg)](https://github.com/adabox-aio/ogmios-java-client/actions/workflows/.github/workflows/maven.yml)
[![codeQL](https://github.com/adabox-aio/ogmios-java-client/actions/workflows/codeql-analysis.yml/badge.svg)](https://github.com/adabox-aio/ogmios-java-client/actions/workflows/.github/workflows/codeql-analysis.yml)
[![Coverage](.github/badges/jacoco.svg)](https://github.com/adabox-aio/ogmios-java-client/actions/workflows/.github/workflows/maven.yml)
[![License](https://img.shields.io:/github/license/adabox-aio/ogmios-java-client?color=blue&label=license)](https://opensource.org/licenses/Apache-2.0)
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
- Transaction Evaluation
- Structured Java Objects logging
- Full ledger state query support:
  - [x] blockHeight
  - [x] chainTip
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

## Getting Started

### Dependency management tool

Below is a brief guide to using dependency management tools like maven or gradle.

#### Maven
To use maven add this dependency to your pom.xml:
```xml
<dependency>
    <groupId>io.github.adabox-aio</groupId>
    <artifactId>ogmios-java-client</artifactId>
    <version>1.0.0</version>
</dependency>
```

#### Gradle
To use Gradle add the maven central repository to your repositories list:
```xml
mavenCentral()
```
Then you can just add the latest version to your build.
```xml
compile "io.github.adabox-aio:ogmios-java-client:1.0.0"
```
Or this option if you use gradle 7.0 and above.
```xml
implementation io.github.adabox-aio:ogmios-java-client:1.0.0'
```

### Hosted Dandelion's instances, by [Gimbalabs](https://gimbalabs.com/).
`wss://ogmios-api.mainnet.dandelion.link/` - Mainnet

`wss:/ogmios-api.testnet.dandelion.link/` - Testnet

### Initialize Secured Ogmios Websocket Client
```java
ogmiosWSClient = new OgmiosWSClient(new URI("wss://ogmios-api.testnet.dandelion.link/"));
ogmiosWSClient.setSocketFactory(SSLSocketFactory.getDefault());
ogmiosWSClient.connectBlocking(60, TimeUnit.SECONDS);
```

### Basic Current Protocol Parameters Query Example
```java
CurrentProtocolParameters currentProtocolParameters = ogmiosWSClient.currentProtocolParameters();
log.info(currentProtocolParameters.toString());
```

## Clone & Build with Maven
```shell
git clone https://github.com/adabox-aio/ogmios-java-client.git
cd ogmios-java-client
mvn clean install
```

<hr/>

<p style="text-align: center">
  <a href="CONTRIBUTING.md">:triangular_ruler: Contributing</a>
    |
  <a href="SPONSORS.md">:gift_heart: Sponsors</a>
</p>
