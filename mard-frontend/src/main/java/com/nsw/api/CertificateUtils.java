/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.api;

import java.util.Date;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXCertPathBuilderResult;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.naming.Context;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author havm2
 */
public class CertificateUtils {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(CertificateUtils.class);

//    public static boolean validateCert(String cert, String infoCheck) throws Exception {
//        boolean bReturn = false;
//        X509Certificate x509Cert = CertUtils.getX509Cert(cert);
//        //CertificateFactory fact = CertificateFactory.getInstance("X.509");
//        //FileInputStream is = new FileInputStream("C:\\vOfficeUpload\\ca\\vietan83.cer");
//        //X509Certificate x509Cert = (X509Certificate) fact.generateCertificate(is);
//        if (!x509Cert.getSubjectDN().toString().contains(infoCheck)) {
//            return false;
//        }
//        long current = (new Date()).getTime();
//        if (x509Cert.getNotBefore().getTime() >= current || x509Cert.getNotAfter().getTime() <= current) {
//        } else {
//            String issuer = x509Cert.getIssuerDN().getName();
//            String viettel = ResourceBundleUtil.getString("viettel-ca");
//            String vnpt = ResourceBundleUtil.getString("vnpt-ca");
//            String bkav = ResourceBundleUtil.getString("bkav-ca");
//            String fpt = ResourceBundleUtil.getString("fpt-ca");
//            String nacencom = ResourceBundleUtil.getString("nacencom-ca");
//            String ck = ResourceBundleUtil.getString("ck-ca");
//            String newtel = ResourceBundleUtil.getString("newtel-ca");
//            String smartsign = ResourceBundleUtil.getString("smartsign-ca");
//            String safe = ResourceBundleUtil.getString("safe-ca");
//
//            String crlUrl = "";
//            String rootCA = "";
//            String crlRootPath = ResourceBundleUtil.getString("directory");
//            boolean checkOnline = Boolean.parseBoolean(ResourceBundleUtil.getString("check_certificate_online"));
//            if (issuer.contains(viettel)) {
//                if (checkOnline) {
//                    crlUrl = "http://crl.viettel-ca.vn/Viettel-CA.crl";
//                } else {
//                    crlUrl = crlRootPath + File.separator + "crl/Viettel-CA.crl";
//                }
//                rootCA = crlRootPath + File.separator + "CA/viettel-ca.cer";
//            } else if (issuer.contains(vnpt)) {
//                rootCA = crlRootPath + File.separator + "CA/VNPTCA.cer";
//            } else if (issuer.contains(bkav)) {
//                rootCA = crlRootPath + File.separator + "CA/BKAVCA.cer";
//            } else if (issuer.contains(fpt)) {
//                rootCA = crlRootPath + File.separator + "CA/FPT-CA.cer";
//            } else if (issuer.contains(nacencom)) {
//                rootCA = crlRootPath + File.separator + "CA/CA2.cer";
//            } else if (issuer.contains(ck)) {
//                rootCA = crlRootPath + File.separator + "CA/CKCA.cer";
//            } else if (issuer.contains(newtel)) {
//                rootCA = crlRootPath + File.separator + "CA/newtel-ca.cer";
//            } else if (issuer.contains(smartsign)) {
//                rootCA = crlRootPath + File.separator + "CA/SmartSignCer.cer";
//            } else if (issuer.contains(safe)) {
//                rootCA = crlRootPath + File.separator + "CA/cerSafeCA.cer";
//            }
//            InputStream stream = null;
//            try {
//                bReturn = true;
//                stream = new FileInputStream(rootCA);
//                CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
//                X509Certificate root = (X509Certificate) certFactory.generateCertificate(stream);
//                PublicKey pk = root.getPublicKey();
//                x509Cert.verify(pk);
//            } catch (CertificateException | NoSuchAlgorithmException | InvalidKeyException | NoSuchProviderException | SignatureException en) {
//                bReturn = false;
//                log.error(en);
//            } finally {
//                if (stream != null) {
//                    stream.close();
//                }
//            }
//            if (bReturn && checkOnline) {
//                X509CRL crl = getCRL(crlUrl);
//                try {
//                    x509Cert.checkValidity();
//                } catch (Exception en) {
//                    log.error(en);
//                    //System.out.println(en);
//                }
//                bReturn = !crl.isRevoked(x509Cert);
//
//            }
//        }
//        return bReturn;
//    }
    /**
     * Downloads CRL from given URL. Supports http, https, ftp and ldap based
     * URLs.
     */
    private static X509CRL getCRL(String crlURL) throws Exception {
        if (crlURL.startsWith("http://") || crlURL.startsWith("https://")
                || crlURL.startsWith("ftp://")) {
            return downloadCRLFromWeb(crlURL);
        } else if (crlURL.startsWith("ldap://")) {
            return downloadCRLFromLDAP(crlURL);
        } else {
            return getCRLFromFile(crlURL);
        }
    }

    /**
     * Downloads a CRL from given LDAP url, e.g.
     * ldap://ldap.infonotary.com/dc=identity-ca,dc=infonotary,dc=com
     */
    private static X509CRL downloadCRLFromLDAP(String ldapURL) throws Exception {
        Map<String, String> env = new ConcurrentHashMap<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, ldapURL);

        DirContext ctx = new InitialDirContext((Hashtable) env);
        Attributes avals = ctx.getAttributes("");
        Attribute aval = avals.get("certificateRevocationList;binary");
        byte[] val = (byte[]) aval.get();
        if ((val == null) || (val.length == 0)) {
            throw new Exception(
                    "Can not download CRL from: " + ldapURL);
        } else {
            InputStream inStream = new ByteArrayInputStream(val);
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            return (X509CRL) cf.generateCRL(inStream);
        }
    }

    /**
     * Downloads a CRL from given HTTP/HTTPS/FTP URL, e.g.
     * http://crl.infonotary.com/crl/identity-ca.crl
     */
    private static X509CRL downloadCRLFromWeb(String crlURL) throws MalformedURLException,
            IOException, CertificateException,
            CRLException {
        URL url = new URL(crlURL);
        InputStream crlStream = url.openStream();
        try {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            return (X509CRL) cf.generateCRL(crlStream);
        } finally {
            crlStream.close();
        }
    }

    private static X509CRL getCRLFromFile(String filePath) throws MalformedURLException,
            IOException, CertificateException,
            CRLException {
        InputStream crlStream = new FileInputStream(filePath);
        try {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            return (X509CRL) cf.generateCRL(crlStream);
        } finally {
            crlStream.close();
        }
    }

    public static X509Certificate getX509Cert(String CertStr) throws Exception {
        if (!CertStr.isEmpty()) {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            return (X509Certificate) cf.generateCertificate(new ByteArrayInputStream(Base64.decodeBase64(CertStr.getBytes())));
        }
        return null;
    }

}
