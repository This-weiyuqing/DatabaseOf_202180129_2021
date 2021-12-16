package com.njit;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.sql.*;
import db.*;
import entity.*;
import java.util.*;

/**
 * @author 35861
 */
public class personselect extends JFrame {
    private JTable table;
    private MyTableModel tableModel;
    public personselect(){
        this.setSize(600,300);
        this.setTitle("员工信息");
        this.setLocationRelativeTo(getOwner());

        tableModel=getModel();
        TableModel model;
        table=new JTable(tableModel);

        table.setPreferredScrollableViewportSize(new Dimension(500,250));
        JScrollPane scroll=new JScrollPane(table);
        getContentPane().add(scroll,BorderLayout.CENTER);

    }
    private MyTableModel getModel(){
        MyTableModel tableModel=new MyTableModel();
        db dbcon;
        try {
            dbcon = new db();
            ResultSet rs = dbcon.executeQuery("select * from person");
            ResultSetMetaData rsmd = rs.getMetaData();
            int Colnum = rsmd.getColumnCount();
            int i;
            for (i = 1; i < Colnum; i++) {
                tableModel.addColumn(rsmd.getColumnName(i));
            }
            ArrayList<PersonEntity> v=new ArrayList<PersonEntity>();
            while (rs.next()){
                PersonEntity person=new PersonEntity();

                person.setNo((rs.getString("No")));
                person.setName(rs.getString("name"));
                person.setSex(rs.getString("sex"));
                person.setBrithday(String.valueOf(rs.getDate("birthday")));


                person.setProfessor(rs.getString("professor"));
                person.setDeptno(rs.getString("deptNo"));
                v.add(person);

            }
            rs.close();
            for ( i = 0; i <v.size() ; i++) {
                tableModel.addRow(new Object[]{
                        v.get(i).getNo(),v.get(i).getName(),v.get(i).getSex(),v.get(i).getBrithday(),v.get(i).getProfessor(),v.get(i).getDeptno()
                });
            }dbcon.closeConn();
        }catch(SQLException sqle){
            System.out.println(sqle.toString());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }return tableModel;
    }
    public static void main(String[] args){
        personselect w=new personselect();
        w.setVisible(true);
    }
}
