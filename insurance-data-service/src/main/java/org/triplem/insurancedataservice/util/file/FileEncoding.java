package org.triplem.insurancedataservice.util.file;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.mozilla.universalchardet.Constants;

import java.util.Arrays;
import java.util.Optional;

@AllArgsConstructor
@Getter
public enum FileEncoding {

    BOM_PLACEHOLDER("-BOM"),
    UTF_8(Constants.CHARSET_UTF_8),
    UTF_8_BOM(Constants.CHARSET_UTF_8 + BOM_PLACEHOLDER.getEncoding()),
    UTF_16_BE(Constants.CHARSET_UTF_16BE),
    UTF_16_BE_BOM(Constants.CHARSET_UTF_16BE + BOM_PLACEHOLDER.getEncoding()),
    US_ASCII(Constants.CHARSET_US_ASCCI);

    private final String encoding;

    public static FileEncoding getFileEncodingFromName(String encodingName) {
        FileEncoding fileEncoding;
        Optional<FileEncoding> optionalFileEncoding =
            Arrays.stream(FileEncoding.values()).filter(encoding -> encoding.getEncoding().equalsIgnoreCase(encodingName)).findFirst();
        if(optionalFileEncoding.isPresent())
            fileEncoding = optionalFileEncoding.get();
        else
            fileEncoding = UTF_8;
        return fileEncoding;
    }

    public boolean isBomEncoding() {
        return this.getEncoding().contains(BOM_PLACEHOLDER.getEncoding());
    }

}
