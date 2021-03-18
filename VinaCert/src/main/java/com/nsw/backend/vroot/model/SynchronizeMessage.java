package com.nsw.backend.vroot.model;



import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "\"SynchronizeMessage\"",schema = "MARD")
public class SynchronizeMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBD_MESSAGE_SEQ")
    @SequenceGenerator(sequenceName = "TBD_MESSAGE_SEQ", schema = "MARD", initialValue = 1, allocationSize = 1, name = "TBD_MESSAGE_SEQ")
    @Column(name = "\"SyncMessageId\"")
    private Long syncMessageId;

    @Column(name = "\"DocumentType\"")
    private String documentType;

    @Column(name = "\"MessageType\"")
    private Long messageType;

    @Column(name = "\"Function\"")
    private Long function;

    @Column(name = "\"Reference\"")
    private String reference;

    @Column(name = "\"PreReference\"")
    private String preReference;

    @Column(name = "\"DocumentYear\"")
    private Long documentYear;

    @Column(name = "\"Content\"")
    private String content;

    @Column(name = "\"CreatedDate\"")
    private Date createdDate;

    @Column(name = "\"SendDate\"")
    private Date sendDate;

    @Column(name = "\"MessageId\"")
    private String messageId;

    @Column(name = "\"Response\"")
    private String response;

    public Long getSyncMessageId() {
        return syncMessageId;
    }

    public void setSyncMessageId(Long syncMessageId) {
        this.syncMessageId = syncMessageId;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public Long getMessageType() {
        return messageType;
    }

    public void setMessageType(Long messageType) {
        this.messageType = messageType;
    }

    public Long getFunction() {
        return function;
    }

    public void setFunction(Long function) {
        this.function = function;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getPreReference() {
        return preReference;
    }

    public void setPreReference(String preReference) {
        this.preReference = preReference;
    }

    public Long getDocumentYear() {
        return documentYear;
    }

    public void setDocumentYear(Long documentYear) {
        this.documentYear = documentYear;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
