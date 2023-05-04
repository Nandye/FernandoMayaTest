# Change Log

---
## Notes:
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/).

## [Unreleased] - yyyy-mm-dd
### Added
### Changed
### deleted
### Fixed
- [PROJECTNAME-TTTT](http://tickets.projectname.com/browse/PROJECTNAME-TTTT)
  PATCH Add logic to runsheet teaser delete to delete corresponding
  schedule cards.ter

---
## [0.4.0] - 2023-05-04
### Add
* Added the logic that I forget implement, the service should only return one price looking 
* for the priority column on DB.
* In the future, if the DB grow up on number of rows and can exist the possibility that two price coexist 
* with the same priority its will needed to add integration test and the logic for control this casuistic 
* maybe looking for the greater price or something like that.

## [0.3.1] - 2023-05-03 :: feature/CoverTest https://github.com/Nandye/FernandoMayaTest/tree/feature/CoverTest
### Add
* Add a cover test and ControllerAdvice exception handler

## [0.3.0] - 2023-05-02 :: feature/CoverTest https://github.com/Nandye/FernandoMayaTest/tree/feature/CoverTest
### Fixed
* Fix DB definition, add a new primary key and fix a predicate on jpa criteria.

## [0.2.1] - 2023-05-02 :: fix/FixDataBase https://github.com/Nandye/FernandoMayaTest/pull/7
### Fixed
* Fix DB definition, add a new primary key and fix a predicate on jpa criteria.

## [0.2.0] - 2023-05-01 :: Core
### Added
* Added core layer, implementing Domain-Driven Design

## [0.1.0] - 2023-04-30 :: Model
### Added
  * Added Changelog file
  * Added data model
  * Added MapStruct for mappers