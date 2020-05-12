package com.inventory.common;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class FilterJtable {

public static void setFilterJtable(JTable jTable, final JTextField jtfFilter) {
    final TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(jTable.getModel());
    jTable.setRowSorter(rowSorter);
    jtfFilter.getDocument().addDocumentListener(new DocumentListener(){

        @Override
        public void insertUpdate(DocumentEvent e) {
            String text = jtfFilter.getText();

            if (text.trim().length() == 0) {
                rowSorter.setRowFilter(null);
            } else {
                rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            String text = jtfFilter.getText();

            if (text.trim().length() == 0) {
                rowSorter.setRowFilter(null);
            } else {
                rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    });
}
}