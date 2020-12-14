package com.nsw.mard.helper;

import com.nsw.mard.p9.model.*;
import pl.jsolve.templ4docx.variable.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Mard09Helper {
    public static Variables genWord15A(Tbdgiaycnkd09 gp) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Variables variables = new Variables();
        String space = ".....";


        variables.addTextVariable(new TextVariable("#{DepartmentLisenceName}", gp.getFiDepartmentLicenseName() == null ? "" : gp.getFiDepartmentLicenseName().toUpperCase()));
        variables.addTextVariable(new TextVariable("#{CertificateNo}", gp.getFiCertificateNo() == null ? "" : gp.getFiCertificateNo()));

        variables.addTextVariable(new TextVariable("#{NameOfRegistration}", gp.getFiNameOfRegistration() == null ? "" : gp.getFiNameOfRegistration().toUpperCase()));
        variables.addTextVariable(new TextVariable("#{AddressOfRegistration}", gp.getFiAddressOfRegistration() == null ? "" : gp.getFiAddressOfRegistration()));
        variables.addTextVariable(new TextVariable("#{IdentityNo}", gp.getFiIdentityNo() == null ? "" : gp.getFiIdentityNo()));
        if (gp.getFiIssueDate() != null){
            variables.addTextVariable(new TextVariable("#{IssueDate}", sdf.format(gp.getFiIssueDate())));
        } else {
            variables.addTextVariable(new TextVariable("#{IssueDate}", ""));
        }


        variables.addTextVariable(new TextVariable("#{IssuePlace}", gp.getFiIssuePlace() == null ? "" : gp.getFiIssuePlace()));
        variables.addTextVariable(new TextVariable("#{FaxOfRegistration}", gp.getFiFaxOfRegistration() == null ? "" : gp.getFiFaxOfRegistration()));
        variables.addTextVariable(new TextVariable("#{EmailOfRegistration}", gp.getFiEmailOfRegistration() == null ? "" : gp.getFiEmailOfRegistration()));
        variables.addTextVariable(new TextVariable("#{PhoneOfRegistration}", gp.getFiPhoneOfRegistration() == null ? "" : gp.getFiPhoneOfRegistration()));


        TableVariable productTableVariable = new TableVariable();
        List<Variable> fiNameOfGoods = new ArrayList<>();
        List<Variable> fiAges = new ArrayList<>();
        List<Variable> fiIncludeMales = new ArrayList<>();
        List<Variable> fiIncludeFemales = new ArrayList<>();
        List<Variable> fiNumbers = new ArrayList<>();
        List<Variable> fiPurposeUses = new ArrayList<>();

        double total = 0;

        for (TbdCnkdHh09 hh: gp.getLstGood()) {
            total += hh.getFiNumber();
            fiNameOfGoods.add(new TextVariable("#{NameOfGoods}", hh.getFiProductName()));
            fiAges.add(new TextVariable("#{Age}", String.valueOf(hh.getFiAge())));
            fiIncludeMales.add(new TextVariable("#{IncludeMale}", hh.getFiIncludeMale() == 0 ? "" : "X"));
            fiIncludeFemales.add(new TextVariable("#{IncludeFemale}", hh.getFiIncludeFemale() == 0 ? "" : "X"));
            fiNumbers.add(new TextVariable("#{Number}", String.valueOf(hh.getFiNumber())));
            fiPurposeUses.add(new TextVariable("#{fiPurposeUse}", hh.getFiPurposeUse() ==  null ? "" : hh.getFiPurposeUse()));
        }

        productTableVariable.addVariable(fiNameOfGoods);
        productTableVariable.addVariable(fiAges);
        productTableVariable.addVariable(fiIncludeMales);
        productTableVariable.addVariable(fiIncludeFemales);
        productTableVariable.addVariable(fiNumbers);
        productTableVariable.addVariable(fiPurposeUses);

        variables.addTableVariable(productTableVariable);

        variables.addTextVariable(new TextVariable("#{fiTotal}", String.valueOf(total)));

        variables.addTextVariable(new TextVariable("#{fiTotalQuantityOrVolumnByText}", gp.getFiTotalQuantityOrVolumnByText() == null ? "" : gp.getFiTotalQuantityOrVolumnByText()));

        variables.addTextVariable(new TextVariable("#{fiNameOfExporter}", gp.getFiNameOfExporter() == null ? "" : gp.getFiNameOfExporter()));
        variables.addTextVariable(new TextVariable("#{fiAddressOfExporter}", gp.getFiAddressOfExporter() == null ? "" : gp.getFiAddressOfExporter()));

        variables.addTextVariable(new TextVariable("#{fiOriginationExport}", gp.getFiOriginationExport() == null ? "" : gp.getFiOriginationExport()));
        variables.addTextVariable(new TextVariable("#{fiOriginationTransit}", gp.getFiOriginationTransit() == null ? "" : gp.getFiOriginationTransit()));
        variables.addTextVariable(new TextVariable("#{fiPortOfDestinationAddress}", gp.getFiPortOfDestinationAddress() == null ? "" : gp.getFiPortOfDestinationAddress()));
        variables.addTextVariable(new TextVariable("#{fiOtherItems}", gp.getFiOtherItems() == null ? "" : gp.getFiOtherItems()));
        variables.addTextVariable(new TextVariable("#{fiDocumentAttach}", gp.getFiDocumentAttach() == null ? "" : gp.getFiDocumentAttach()));
        variables.addTextVariable(new TextVariable("#{fiTransportType}", gp.getFiTransportType() == null ? "" : gp.getFiTransportType()));
        variables.addTextVariable(new TextVariable("#{fiTransportTypeOfAntiseptic}", gp.getFiTransportTypeOfAntiseptic() == null ? "" : gp.getFiTransportTypeOfAntiseptic()));
        variables.addTextVariable(new TextVariable("#{fiTransportTypeOfConcentration}", gp.getFiTransportTypeOfConcentration() == null ? "" : gp.getFiTransportTypeOfConcentration()));
        variables.addTextVariable(new TextVariable("#{fiSignConfirmAddress}", gp.getFiSignConfirmAddress() == null ? "" : gp.getFiSignConfirmAddress()));

        if (gp.getFiSignConfirmDate() == null) {
            variables.addTextVariable(new TextVariable("#{fiSignConfirmDate}", ""));
        } else {
            variables.addTextVariable(new TextVariable("#{fiSignConfirmDate}", sdf.format(gp.getFiSignConfirmDate())));
        }

        if (gp.getFiEffectiveDate() == null) {
            variables.addTextVariable(new TextVariable("#{fiEffectiveDate}", ""));
        } else {
            variables.addTextVariable(new TextVariable("#{fiEffectiveDate}", sdf.format(gp.getFiEffectiveDate())));
        }

        String lstImmues = "";

        for (Tbdtiemphong09 tbdtiemphong09: gp.getLstImmunes()) {
            char index = 'a';
            String ngayTiem = "";
            if (tbdtiemphong09.getFiVaccinationDate() != null) {
                ngayTiem = sdf.format(tbdtiemphong09.getFiVaccinationDate());
            }
            lstImmues += String.format("%s/ %s Tiêm phòng ngày %s\n", String.valueOf(index), tbdtiemphong09.getFiDiseaseName(), ngayTiem);
        }


        variables.addTextVariable(new TextVariable("#{fiCreaterName}", gp.getFiCreaterName() == null ? "" : gp.getFiCreaterName()));
        variables.addTextVariable(new TextVariable("#{fiLstImmunes}", lstImmues));
        variables.addTextVariable(new TextVariable("#{fiSignConfirmName}", gp.getFiSignConfirmName() == null ? "" : gp.getFiSignConfirmName()));

        return variables;
    }

    public static Variables genWord15B(Tbdgiaycnkd09 gp) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Variables variables = new Variables();
        String space = ".....";


        variables.addTextVariable(new TextVariable("#{DepartmentLisenceName}", gp.getFiDepartmentLicenseName() == null ? "" : gp.getFiDepartmentLicenseName().toUpperCase()));
        variables.addTextVariable(new TextVariable("#{CertificateNo}", gp.getFiCertificateNo() == null ? "" : gp.getFiCertificateNo()));

        variables.addTextVariable(new TextVariable("#{NameOfRegistration}", gp.getFiNameOfRegistration() == null ? "" : gp.getFiNameOfRegistration().toUpperCase()));
        variables.addTextVariable(new TextVariable("#{AddressOfRegistration}", gp.getFiAddressOfRegistration() == null ? "" : gp.getFiAddressOfRegistration()));
        variables.addTextVariable(new TextVariable("#{IdentityNo}", gp.getFiIdentityNo() == null ? "" : gp.getFiIdentityNo()));
        if (gp.getFiIssueDate() != null){
            variables.addTextVariable(new TextVariable("#{IssueDate}", sdf.format(gp.getFiIssueDate())));
        } else {
            variables.addTextVariable(new TextVariable("#{IssueDate}", ""));
        }


        variables.addTextVariable(new TextVariable("#{IssuePlace}", gp.getFiIssuePlace() == null ? "" : gp.getFiIssuePlace()));
        variables.addTextVariable(new TextVariable("#{FaxOfRegistration}", gp.getFiFaxOfRegistration() == null ? "" : gp.getFiFaxOfRegistration()));
        variables.addTextVariable(new TextVariable("#{EmailOfRegistration}", gp.getFiEmailOfRegistration() == null ? "" : gp.getFiEmailOfRegistration()));
        variables.addTextVariable(new TextVariable("#{PhoneOfRegistration}", gp.getFiPhoneOfRegistration() == null ? "" : gp.getFiPhoneOfRegistration()));


        TableVariable productTableVariable = new TableVariable();
        List<Variable> fiNameOfGoods = new ArrayList<>();
        List<Variable> fiPackings = new ArrayList<>();
        List<Variable> fiNetWeights = new ArrayList<>();
        List<Variable> fiNumbers = new ArrayList<>();
        List<Variable> fiPurposeUses = new ArrayList<>();

        double total = 0;
        double totalNet = 0;

        for (TbdCnkdHh09 hh: gp.getLstGood()) {
            total += hh.getFiNumber();
            totalNet += hh.getFiNetWeight();
            fiNameOfGoods.add(new TextVariable("#{NameOfGoods}", hh.getFiProductName()));
            fiPackings.add(new TextVariable("#{Packing}", hh.getFiPackingWay() == null ? "" : hh.getFiPackingWay()));
            fiNetWeights.add(new TextVariable("#{NetWeight}", String.valueOf(hh.getFiNetWeight())));
            fiNumbers.add(new TextVariable("#{Number}", String.valueOf(hh.getFiNumber())));
            fiPurposeUses.add(new TextVariable("#{fiPurposeUse}", hh.getFiPurposeUse() ==  null ? "" : hh.getFiPurposeUse()));
        }

        productTableVariable.addVariable(fiNameOfGoods);
        productTableVariable.addVariable(fiPackings);
        productTableVariable.addVariable(fiNetWeights);
        productTableVariable.addVariable(fiNumbers);
        productTableVariable.addVariable(fiPurposeUses);

        variables.addTableVariable(productTableVariable);

        variables.addTextVariable(new TextVariable("#{Total}", String.valueOf(total)));
        variables.addTextVariable(new TextVariable("#{TotalNet}", String.valueOf(totalNet)));

        variables.addTextVariable(new TextVariable("#{fiTotalQuantityOrVolumnByText}", gp.getFiTotalQuantityOrVolumnByText() == null ? "" : gp.getFiTotalQuantityOrVolumnByText()));

        variables.addTextVariable(new TextVariable("#{fiNameOfExporter}", gp.getFiNameOfExporter() == null ? "" : gp.getFiNameOfExporter()));
        variables.addTextVariable(new TextVariable("#{fiAddressOfExporter}", gp.getFiAddressOfExporter() == null ? "" : gp.getFiAddressOfExporter()));

        variables.addTextVariable(new TextVariable("#{NameOfProduce}", gp.getFiNameOfProduce() == null ? "" : gp.getFiNameOfProduce()));
        variables.addTextVariable(new TextVariable("#{AddressOfProduce}", gp.getFiAddressOfProduce() == null ? "" : gp.getFiAddressOfProduce()));

        variables.addTextVariable(new TextVariable("#{fiOriginationExport}", gp.getFiOriginationExport() == null ? "" : gp.getFiOriginationExport()));
        variables.addTextVariable(new TextVariable("#{fiOriginationTransit}", gp.getFiOriginationTransit() == null ? "" : gp.getFiOriginationTransit()));
        variables.addTextVariable(new TextVariable("#{fiPortOfDestinationAddress}", gp.getFiPortOfDestinationAddress() == null ? "" : gp.getFiPortOfDestinationAddress()));
        variables.addTextVariable(new TextVariable("#{fiPortOfDestinationName}", gp.getFiPortOfDestinationName() == null ? "" : gp.getFiPortOfDestinationName()));
        variables.addTextVariable(new TextVariable("#{fiOtherItems}", gp.getFiOtherItems() == null ? "" : gp.getFiOtherItems()));
        variables.addTextVariable(new TextVariable("#{fiDocumentAttach}", gp.getFiDocumentAttach() == null ? "" : gp.getFiDocumentAttach()));
        variables.addTextVariable(new TextVariable("#{fiTransportType}", gp.getFiTransportType() == null ? "" : gp.getFiTransportType()));
        variables.addTextVariable(new TextVariable("#{fiTransportTypeOfAntiseptic}", gp.getFiTransportTypeOfAntiseptic() == null ? "" : gp.getFiTransportTypeOfAntiseptic()));
        variables.addTextVariable(new TextVariable("#{fiTransportTypeOfConcentration}", gp.getFiTransportTypeOfConcentration() == null ? "" : gp.getFiTransportTypeOfConcentration()));
        variables.addTextVariable(new TextVariable("#{fiSignConfirmAddress}", gp.getFiSignConfirmAddress() == null ? "" : gp.getFiSignConfirmAddress()));


        variables.addTextVariable(new TextVariable("#{AnimalOfAntiseptic}", gp.getFiAnimalOfAntiseptic() == null ? "" : gp.getFiAnimalOfAntiseptic()));
        variables.addTextVariable(new TextVariable("#{AnimalOfConcentration}", gp.getFiAnimalOfConcentration() == null ? "" : gp.getFiAnimalOfConcentration()));


        if (gp.getFiImportDate() == null) {
            variables.addTextVariable(new TextVariable("#{ImportDate}", ""));
        } else {
            variables.addTextVariable(new TextVariable("#{ImportDate}", sdf.format(gp.getFiImportDate())));
        }

        if (gp.getFiSignConfirmDate() == null) {
            variables.addTextVariable(new TextVariable("#{fiSignConfirmDate}", ""));
        } else {
            variables.addTextVariable(new TextVariable("#{fiSignConfirmDate}", sdf.format(gp.getFiSignConfirmDate())));
        }

        if (gp.getFiEffectiveDate() == null) {
            variables.addTextVariable(new TextVariable("#{fiEffectiveDate}", ""));
        } else {
            variables.addTextVariable(new TextVariable("#{fiEffectiveDate}", sdf.format(gp.getFiEffectiveDate())));
        }

        String lstImmues = "";

        for (Tbdtiemphong09 tbdtiemphong09: gp.getLstImmunes()) {
            char index = 'a';
            String ngayTiem = "";
            if (tbdtiemphong09.getFiVaccinationDate() != null) {
                ngayTiem = sdf.format(tbdtiemphong09.getFiVaccinationDate());
            }
            lstImmues += String.format("%s/ %s Tiêm phòng ngày %s", String.valueOf(index), tbdtiemphong09.getFiDiseaseName(), ngayTiem);
        }


        variables.addTextVariable(new TextVariable("#{fiCreaterName}", gp.getFiCreaterName() == null ? "" : gp.getFiCreaterName()));
        variables.addTextVariable(new TextVariable("#{fiLstImmunes}", lstImmues));
        variables.addTextVariable(new TextVariable("#{fiSignConfirmName}", gp.getFiSignConfirmName() == null ? "" : gp.getFiSignConfirmName()));

        return variables;
    }

    public static Variables genWord14A(Tbdgiayvc09 gp) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Variables variables = new Variables();
        String space = ".....";


        variables.addTextVariable(new TextVariable("#{fiDepartmentLisenceName}", gp.getFiDepartmentLicenseName() == null ? "" : gp.getFiDepartmentLicenseName().toUpperCase()));
        variables.addTextVariable(new TextVariable("#{fiCertificateNo}", gp.getFiCertificateNo() == null ? "" : gp.getFiCertificateNo()));

        variables.addTextVariable(new TextVariable("#{fiNameOfRegistration}", gp.getFiNameOfRegistration() == null ? "" : gp.getFiNameOfRegistration().toUpperCase()));
        variables.addTextVariable(new TextVariable("#{fiAddressOfRegistration}", gp.getFiAddressOfRegistration() == null ? "" : gp.getFiAddressOfRegistration()));
        variables.addTextVariable(new TextVariable("#{fiIdentityNo}", gp.getFiIdentityNo() == null ? "" : gp.getFiIdentityNo()));
        if (gp.getFiIssueDate() != null){
            variables.addTextVariable(new TextVariable("#{fiIssueDate}", sdf.format(gp.getFiIssueDate())));
        } else {
            variables.addTextVariable(new TextVariable("#{fiIssueDate}", ""));
        }


        variables.addTextVariable(new TextVariable("#{fiIssuePlace}", gp.getFiIssuePlace() == null ? "" : gp.getFiIssuePlace()));

        variables.addTextVariable(new TextVariable("#{fiFaxOfRegistration}", gp.getFiFaxOfRegistration() == null ? "" : gp.getFiFaxOfRegistration()));
        variables.addTextVariable(new TextVariable("#{fiEmailOfRegistration}", gp.getFiEmailOfRegistration() == null ? "" : gp.getFiEmailOfRegistration()));
        variables.addTextVariable(new TextVariable("#{fiPhoneOfRegistration}", gp.getFiPhoneOfRegistration() == null ? "" : gp.getFiPhoneOfRegistration()));

        TableVariable productTableVariable = new TableVariable();
        List<Variable> fiNameOfGoods = new ArrayList<>();
        List<Variable> fiAges = new ArrayList<>();
        List<Variable> fiIncludeMales = new ArrayList<>();
        List<Variable> fiIncludeFemales = new ArrayList<>();
        List<Variable> fiNumbers = new ArrayList<>();
        List<Variable> fiPurposeUses = new ArrayList<>();

        double total = 0;

        for (TbdGvcHh09 hh: gp.getLstGood()) {
            total += hh.getFiNumber();
            fiNameOfGoods.add(new TextVariable("#{fiNameOfGoods}", hh.getFiProductName()));
            fiAges.add(new TextVariable("#{fiAge}", String.valueOf(hh.getFiAge())));
            fiIncludeMales.add(new TextVariable("#{fiIncludeMale}", hh.getFiIncludeMale() == 0 ? "" : "X"));
            fiIncludeFemales.add(new TextVariable("#{fiIncludeFeMale}", hh.getFiIncludeFemale() == 0 ? "" : "X"));
            fiNumbers.add(new TextVariable("#{fiQuantityOrVolumn}", String.valueOf(hh.getFiNumber())));
            fiPurposeUses.add(new TextVariable("#{fiPurposeUse}", hh.getFiPurposeUse() ==  null ? "" : hh.getFiPurposeUse()));
        }

        productTableVariable.addVariable(fiNameOfGoods);
        productTableVariable.addVariable(fiAges);
        productTableVariable.addVariable(fiIncludeMales);
        productTableVariable.addVariable(fiIncludeFemales);
        productTableVariable.addVariable(fiNumbers);
        productTableVariable.addVariable(fiPurposeUses);

        variables.addTableVariable(productTableVariable);

        variables.addTextVariable(new TextVariable("#{fiTotalQuantityOrVolumn}", String.valueOf(total)));

        variables.addTextVariable(new TextVariable("#{fiTotalQuantityOrVolumnByText}", gp.getFiTotalQuantityOrVolumn() == null ? "" : gp.getFiTotalQuantityOrVolumn()));

        variables.addTextVariable(new TextVariable("#{fiNameOfExporter}", gp.getFiNameOfExporter() == null ? "" : gp.getFiNameOfExporter()));
        variables.addTextVariable(new TextVariable("#{fiAddressOfExporter}", gp.getFiAddressOfExporter() == null ? "" : gp.getFiAddressOfExporter()));

        variables.addTextVariable(new TextVariable("#{fiOriginationExport}", gp.getFiOriginationExport() == null ? "" : gp.getFiOriginationExport()));
        variables.addTextVariable(new TextVariable("#{fiOriginationTransit}", gp.getFiOriginationTransit() == null ? "" : gp.getFiOriginationTransit()));
        variables.addTextVariable(new TextVariable("#{fiPortOfDestinationName}", gp.getFiPortOfDestinationName() == null ? "" : gp.getFiPortOfDestinationName()));
        variables.addTextVariable(new TextVariable("#{fiDocumentAttach}", gp.getFiDocumentAttach() == null ? "" : gp.getFiDocumentAttach()));
        variables.addTextVariable(new TextVariable("#{fiOtherItems}", gp.getFiOtherItems() == null ? "" : gp.getFiOtherItems()));
        variables.addTextVariable(new TextVariable("#{fiTransportType}", gp.getFiTransportType() == null ? "" : gp.getFiTransportType()));
        variables.addTextVariable(new TextVariable("#{fiLicensePlate}", gp.getFiLicensePlate() == null ? "" : gp.getFiLicensePlate()));
        variables.addTextVariable(new TextVariable("#{fiTransportTypeAntiseptic}", gp.getFiTransportTypeOfAntiseptic() == null ? "" : gp.getFiTransportTypeOfAntiseptic()));
        variables.addTextVariable(new TextVariable("#{fiTransportTypeConcentration}", gp.getFiTransportTypeOfConcentration() == null ? "" : gp.getFiTransportTypeOfConcentration()));
        variables.addTextVariable(new TextVariable("#{fiSignConfirmAddress}", gp.getFiSignConfirmAddress() == null ? "" : gp.getFiSignConfirmAddress()));
        variables.addTextVariable(new TextVariable("#{fiTransportPlace}", gp.getFiTransportPlace() == null ? "" : gp.getFiTransportPlace()));
        variables.addTextVariable(new TextVariable("#{fiTransportStreet}", gp.getFiTransportStreet() == null ? "" : gp.getFiTransportStreet()));

        if (gp.getFiImportDate() == null) {
            variables.addTextVariable(new TextVariable("#{fiImportDate}", ""));
        } else {
            variables.addTextVariable(new TextVariable("#{fiImportDate}", sdf.format(gp.getFiImportDate())));
        }

        if (gp.getFiTransportDate() == null) {
            variables.addTextVariable(new TextVariable("#{fiTransportDate}", ""));
        } else {
            variables.addTextVariable(new TextVariable("#{fiTransportDate}", sdf.format(gp.getFiTransportDate())));
        }

        if (gp.getFiSignConfirmDate() == null) {
            variables.addTextVariable(new TextVariable("#{fiSignConfirmDate}", ""));
        } else {
            variables.addTextVariable(new TextVariable("#{fiSignConfirmDate}", sdf.format(gp.getFiSignConfirmDate())));
        }

        if (gp.getFiEffectiveDate() == null) {
            variables.addTextVariable(new TextVariable("#{fiEffectiveDate}", ""));
        } else {
            variables.addTextVariable(new TextVariable("#{fiEffectiveDate}", sdf.format(gp.getFiEffectiveDate())));
        }


        variables.addTextVariable(new TextVariable("#{fiCreaterName}", gp.getFiCreaterName() == null ? "" : gp.getFiCreaterName()));
        variables.addTextVariable(new TextVariable("#{fiSignConfirmName}", gp.getFiSignConfirmName() == null ? "" : gp.getFiSignConfirmName()));

        return variables;
    }

    public static Variables genWord14B(Tbdgiayvc09 gp) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Variables variables = new Variables();
        String space = ".....";


        variables.addTextVariable(new TextVariable("#{fiDepartmentLisenceName}", gp.getFiDepartmentLicenseName() == null ? "" : gp.getFiDepartmentLicenseName().toUpperCase()));
        variables.addTextVariable(new TextVariable("#{fiCertificateNo}", gp.getFiCertificateNo() == null ? "" : gp.getFiCertificateNo()));

        variables.addTextVariable(new TextVariable("#{fiNameOfRegistration}", gp.getFiNameOfRegistration() == null ? "" : gp.getFiNameOfRegistration().toUpperCase()));
        variables.addTextVariable(new TextVariable("#{fiAddressOfRegistration}", gp.getFiAddressOfRegistration() == null ? "" : gp.getFiAddressOfRegistration()));
        variables.addTextVariable(new TextVariable("#{fiIdentityNo}", gp.getFiIdentityNo() == null ? "" : gp.getFiIdentityNo()));
        if (gp.getFiIssueDate() != null){
            variables.addTextVariable(new TextVariable("#{fiIssueDate}", sdf.format(gp.getFiIssueDate())));
        } else {
            variables.addTextVariable(new TextVariable("#{fiIssueDate}", ""));
        }


        variables.addTextVariable(new TextVariable("#{fiIssuePlace}", gp.getFiIssuePlace() == null ? "" : gp.getFiIssuePlace()));

        variables.addTextVariable(new TextVariable("#{fiFaxOfRegistration}", gp.getFiFaxOfRegistration() == null ? "" : gp.getFiFaxOfRegistration()));
        variables.addTextVariable(new TextVariable("#{fiEmailOfRegistration}", gp.getFiEmailOfRegistration() == null ? "" : gp.getFiEmailOfRegistration()));
        variables.addTextVariable(new TextVariable("#{fiPhoneOfRegistration}", gp.getFiPhoneOfRegistration() == null ? "" : gp.getFiPhoneOfRegistration()));

        TableVariable productTableVariable = new TableVariable();
        List<Variable> fiNameOfGoods = new ArrayList<>();
        List<Variable> fiPackageType = new ArrayList<>();
        List<Variable> fiNetWeight = new ArrayList<>();
        List<Variable> fiNumbers = new ArrayList<>();
        List<Variable> fiPurposeUses = new ArrayList<>();

        double total = 0;
        double totalNW = 0;

        for (TbdGvcHh09 hh: gp.getLstGood()) {
            total += hh.getFiNumber();
            totalNW += hh.getFiNetWeight();
            fiNameOfGoods.add(new TextVariable("#{fiNameOfGoods}", hh.getFiProductName()));
            fiPackageType.add(new TextVariable("#{fiWayOfPackinglist}", hh.getFiPackingWay() == null ? "" : hh.getFiPackingWay()));
            fiNetWeight.add(new TextVariable("#{fiNetWeight}", String.valueOf(hh.getFiNetWeight())));
            fiNumbers.add(new TextVariable("#{fiQuantityOrVolumn}", String.valueOf(hh.getFiNumber())));
            fiPurposeUses.add(new TextVariable("#{fiPurposeUse}", hh.getFiPurposeUse() ==  null ? "" : hh.getFiPurposeUse()));
        }

        productTableVariable.addVariable(fiNameOfGoods);
        productTableVariable.addVariable(fiPackageType);
        productTableVariable.addVariable(fiNetWeight);
        productTableVariable.addVariable(fiNumbers);
        productTableVariable.addVariable(fiPurposeUses);

        variables.addTableVariable(productTableVariable);

        variables.addTextVariable(new TextVariable("#{Total}", String.valueOf(total)));
        variables.addTextVariable(new TextVariable("#{TotalWeight}", String.valueOf(totalNW)));

        variables.addTextVariable(new TextVariable("#{fiTotalQuantityOrVolumnByText}", gp.getFiTotalQuantityOrVolumn() == null ? "" : gp.getFiTotalQuantityOrVolumn()));

        variables.addTextVariable(new TextVariable("#{fiNameOfExporter}", gp.getFiNameOfExporter() == null ? "" : gp.getFiNameOfExporter()));
        variables.addTextVariable(new TextVariable("#{fiAddressOfExporter}", gp.getFiAddressOfExporter() == null ? "" : gp.getFiAddressOfExporter()));

        variables.addTextVariable(new TextVariable("#{fiOriginationExport}", gp.getFiOriginationExport() == null ? "" : gp.getFiOriginationExport()));
        variables.addTextVariable(new TextVariable("#{fiOriginationTransit}", gp.getFiOriginationTransit() == null ? "" : gp.getFiOriginationTransit()));
        variables.addTextVariable(new TextVariable("#{fiPortOfDestinationName}", gp.getFiPortOfDestinationName() == null ? "" : gp.getFiPortOfDestinationName()));
        variables.addTextVariable(new TextVariable("#{fiDocumentAttach}", gp.getFiDocumentAttach() == null ? "" : gp.getFiDocumentAttach()));
        variables.addTextVariable(new TextVariable("#{fiOtherItems}", gp.getFiOtherItems() == null ? "" : gp.getFiOtherItems()));
        variables.addTextVariable(new TextVariable("#{fiTransportType}", gp.getFiTransportType() == null ? "" : gp.getFiTransportType()));
        variables.addTextVariable(new TextVariable("#{fiLicensePlate}", gp.getFiLicensePlate() == null ? "" : gp.getFiLicensePlate()));
        variables.addTextVariable(new TextVariable("#{fiTransportTypeAntiseptic}", gp.getFiTransportTypeOfAntiseptic() == null ? "" : gp.getFiTransportTypeOfAntiseptic()));
        variables.addTextVariable(new TextVariable("#{fiTransportTypeOfConcentration}", gp.getFiTransportTypeOfConcentration() == null ? "" : gp.getFiTransportTypeOfConcentration()));
        variables.addTextVariable(new TextVariable("#{fiSignConfirmAddress}", gp.getFiSignConfirmAddress() == null ? "" : gp.getFiSignConfirmAddress()));
        variables.addTextVariable(new TextVariable("#{fiTransportPlace}", gp.getFiTransportPlace() == null ? "" : gp.getFiTransportPlace()));
        variables.addTextVariable(new TextVariable("#{fiTransportStreet}", gp.getFiTransportStreet() == null ? "" : gp.getFiTransportStreet()));

        if (gp.getFiImportDate() == null) {
            variables.addTextVariable(new TextVariable("#{fiImportDate}", ""));
        } else {
            variables.addTextVariable(new TextVariable("#{fiImportDate}", sdf.format(gp.getFiImportDate())));
        }

        if (gp.getFiTransportDate() == null) {
            variables.addTextVariable(new TextVariable("#{fiTransportDate}", ""));
        } else {
            variables.addTextVariable(new TextVariable("#{fiTransportDate}", sdf.format(gp.getFiTransportDate())));
        }

        if (gp.getFiSignConfirmDate() == null) {
            variables.addTextVariable(new TextVariable("#{fiSignConfirmDate}", ""));
        } else {
            variables.addTextVariable(new TextVariable("#{fiSignConfirmDate}", sdf.format(gp.getFiSignConfirmDate())));
        }

        if (gp.getFiEffectiveDate() == null) {
            variables.addTextVariable(new TextVariable("#{fiEffectiveDate}", ""));
        } else {
            variables.addTextVariable(new TextVariable("#{fiEffectiveDate}", sdf.format(gp.getFiEffectiveDate())));
        }


        variables.addTextVariable(new TextVariable("#{fiCreaterName}", gp.getFiCreaterName() == null ? "" : gp.getFiCreaterName()));
        variables.addTextVariable(new TextVariable("#{fiSignConfirmName}", gp.getFiSignConfirmName() == null ? "" : gp.getFiSignConfirmName()));

        return variables;
    }
}
