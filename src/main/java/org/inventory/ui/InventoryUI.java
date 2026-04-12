package org.inventory.ui;

import org.inventory.model.Product;
import org.inventory.service.InventoryService;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryUI {

    public InventoryUI(ApplicationContext context) {

        InventoryService service =
                context.getBean("inventoryService", InventoryService.class);

        JFrame frame = new JFrame("Inventory System");

        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField qtyField = new JTextField();

        JButton addBtn = new JButton("Add Product");
        JButton viewBtn = new JButton("View Products");

        idField.setBounds(50, 30, 150, 30);
        nameField.setBounds(50, 70, 150, 30);
        qtyField.setBounds(50, 110, 150, 30);

        addBtn.setBounds(50, 150, 150, 30);
        viewBtn.setBounds(50, 190, 150, 30);

        frame.add(idField);
        frame.add(nameField);
        frame.add(qtyField);
        frame.add(addBtn);
        frame.add(viewBtn);

        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);

        // Add Product
        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                int qty = Integer.parseInt(qtyField.getText());

                service.addProduct(new Product(id, name, qty));
                JOptionPane.showMessageDialog(frame, "Product Added!");
            }
        });

        // View Products
        viewBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder data = new StringBuilder();

                for (Product p : service.getAllProducts()) {
                    data.append(p.getId())
                            .append(" - ")
                            .append(p.getName())
                            .append(" - Qty: ")
                            .append(p.getQuantity());

                    if (p.getQuantity() < 5) {
                        data.append(" (Low Stock!)");
                    }

                    data.append("\n");
                }

                JOptionPane.showMessageDialog(frame, data.toString());
            }
        });
    }
}