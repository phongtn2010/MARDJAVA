/*
 * Created on 18 Jul 2017 ( Time 08:39:33 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.backend.mard.p06.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Persistent class for entity stored in table "TBDDINHKEM06"
 *
 * @author Telosys Tools Generator
 */
@Data
public class AttachmentFile implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fiAttachmentId;

    private String fiAttachmentTypeCode;

    private String fiNameOfAttachment;

    private String fiLinkFile;

}
