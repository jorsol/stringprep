/*
 * Copyright 2019, OnGres.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the
 * following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following
 * disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the
 * following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package com.ongres.stringprep.codegenerator;

import com.ongres.stringprep.codegenerator.parsers.ParserBidirectionalTables;
import com.ongres.stringprep.codegenerator.parsers.ParserMappingTables;
import com.ongres.stringprep.codegenerator.parsers.ParserProhibitionTables;
import com.ongres.stringprep.codegenerator.parsers.ParserUnicodeRepertoires;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Parser {
    
  private final List<List<Integer>> unassignedCodePoints;
  private final List<Integer> mapToNothing;
  private final Map<Integer, List<Integer>> mapUsedWithNfkc;
  private final Map<Integer, List<Integer>> mapUsedWithNoNormalization;
  private final List<Integer> asciiSpace;
  private final List<Integer> nonAsciiSpace;
  private final List<List<Integer>> asciiControl;
  private final List<List<Integer>> nonAsciiControl;
  private final List<List<Integer>> privateUse;
  private final List<List<Integer>> nonCharacterCodePoints;
  private final List<List<Integer>> surrogateCodes;
  private final List<List<Integer>> inappropriatePlainText;
  private final List<List<Integer>> inappropriateCanonicalRepresentation;
  private final List<List<Integer>> changeDisplayProperties;
  private final List<List<Integer>> taggingCharacters;
  private final List<List<Integer>> propertyRorAL;
  private final List<List<Integer>> propertyL;
    
  /**
 * Constructor of Parser class used to read all rfc files.
 * @throws IOException if a RFC file can't be read
 */
  public Parser() throws IOException {
    unassignedCodePoints = ParserUnicodeRepertoires.parseUnassignedCodePoints();
    mapToNothing = ParserMappingTables.parseMapToNothing();
    mapUsedWithNfkc = ParserMappingTables.parseMapUsedWithNfkc();
    mapUsedWithNoNormalization = ParserMappingTables.parseMapUsedWithNoNormalization();
    asciiSpace = ParserProhibitionTables.parseAsciiSpace();
    nonAsciiSpace = ParserProhibitionTables.parseNonAsciiSpace();
    asciiControl = ParserProhibitionTables.parseAsciiControl();
    nonAsciiControl = ParserProhibitionTables.parseNonAsciiControl();
    privateUse = ParserProhibitionTables.parsePrivateUse();
    nonCharacterCodePoints = ParserProhibitionTables.parseNonCharacterCodePoints();
    surrogateCodes = ParserProhibitionTables.parseSurrogateCodes();
    inappropriatePlainText = ParserProhibitionTables.parseInappropriatePlainText();
    inappropriateCanonicalRepresentation = 
            ParserProhibitionTables.parseInappropriateCanonicalRepresentation();
    changeDisplayProperties = ParserProhibitionTables.parseChangeDisplayProperties();
    taggingCharacters = ParserProhibitionTables.parseTaggingCharacters();
    propertyRorAL = ParserBidirectionalTables.parseBidirectionalPropertyRorAL();
    propertyL = ParserBidirectionalTables.parseBidirectionalPropertyL();
  }

  public List<List<Integer>> getUnassignedCodePoints() {
    return unassignedCodePoints;
  }

  public List<Integer> getMapToNothing() {
    return mapToNothing;
  }

  public Map<Integer, List<Integer>> getMapUsedWithNfkc() {
    return mapUsedWithNfkc;
  }

  public Map<Integer, List<Integer>> getMapUsedWithNoNormalization() {
    return mapUsedWithNoNormalization;
  }

  public List<Integer> getAsciiSpace() {
    return asciiSpace;
  }

  public List<Integer> getNonAsciiSpace() {
    return nonAsciiSpace;
  }

  public List<List<Integer>> getAsciiControl() {
    return asciiControl;
  }

  public List<List<Integer>> getNonAsciiControl() {
    return nonAsciiControl;
  }

  public List<List<Integer>> getPrivateUse() {
    return privateUse;
  }

  public List<List<Integer>> getNonCharacterCodePoints() {
    return nonCharacterCodePoints;
  }

  public List<List<Integer>> getSurrogateCodes() {
    return surrogateCodes;
  }

  public List<List<Integer>> getInappropriatePlainText() {
    return inappropriatePlainText;
  }

  public List<List<Integer>> getInappropriateCanonicalRepresentation() {
    return inappropriateCanonicalRepresentation;
  }

  public List<List<Integer>> getChangeDisplayProperties() {
    return changeDisplayProperties;
  }

  public List<List<Integer>> getTaggingCharacters() {
    return taggingCharacters;
  }

  public List<List<Integer>> getPropertyRorAL() {
    return propertyRorAL;
  }

  public List<List<Integer>> getPropertyL() {
    return propertyL;
  }
}
