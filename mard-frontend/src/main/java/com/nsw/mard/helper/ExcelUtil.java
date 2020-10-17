package com.nsw.mard.helper;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.Iterator;

public class ExcelUtil {
    public static int getLastRowWithData(Sheet sheet) {
        int rowCount = 0;
        Iterator<Row> iter = sheet.rowIterator();

        while (iter.hasNext()) {
            Row r = iter.next();
            if (!isRowBlank(r)) {
                rowCount = r.getRowNum();
            }
        }

        return rowCount;
    }

    private static  boolean isRowBlank(Row r) {
        boolean ret = true;

        /*
         * If a row is null, it must be blank.
         */
        if (r != null) {
            Iterator<Cell> cellIter = r.cellIterator();
            /*
             * Iterate through all cells in a row.
             */
            while (cellIter.hasNext()) {
                /*
                 * If one of the cells in given row contains data, the row is
                 * considered not blank.
                 */
                if (!isCellBlank(cellIter.next())) {
                    ret = false;
                    break;
                }
            }
        }

        return ret;
    }

    private static boolean isCellBlank(Cell c) {
        return (c == null || c.getCellType() == Cell.CELL_TYPE_BLANK);
    }

    private static boolean isCellEmpty(Cell c) {
        return (c == null || c.getCellType() == Cell.CELL_TYPE_BLANK || (c
                .getCellType() == Cell.CELL_TYPE_STRING && c
                .getStringCellValue().isEmpty()));
    }
}
