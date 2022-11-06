package com.binar.challenge4.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class DBFile {
    private String filename;
    private String filetype;
    private byte[] data;
}
