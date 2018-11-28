//package main.guiComponents;
//
//public class SubmissionTreeViewCell TreeCell<String> {
//
//    private TextField textField;
//
//    public SubmissionTreeViewCell() {
//    }
//
//    @Override
//    public void startEdit() {
//        super.startEdit();
//
//        if (textField == null) {
//            createTextField();
//        }
//        setText(null);
//        setGraphic(textField);
//        textField.selectAll();
//    }
//
//    @Override
//    public void cancelEdit() {
//        super.cancelEdit();
//        setText((String) getItem());
//        setGraphic(getTreeItem().getGraphic());
//    }
//
//    @Override
//    public void updateItem(String item, boolean empty) {
//        super.updateItem(item, empty);
//
//        if (empty) {
//            setText(null);
//            setGraphic(null);
//        } else {
//            if (isEditing()) {
//                if (textField != null) {
//                    textField.setText(getString());
//                }
//                setText(null);
//                setGraphic(textField);
//            } else {
//                setText(getString());
//                setGraphic(getTreeItem().getGraphic());
//            }
//        }
//    }
//
//    private void createTextField() {
//        textField = new TextField(getString());
//        textField.setOnKeyReleased(new EventHandler<KeyEvent>() {
//
//            @Override
//            public void handle(KeyEvent t) {
//                if (t.getCode() == KeyCode.ENTER) {
//                    commitEdit(textField.getText());
//                } else if (t.getCode() == KeyCode.ESCAPE) {
//                    cancelEdit();
//                }
//            }
//        });
//    }
//
//    private String getString() {
//        return getItem() == null ? "" : getItem().toString();
//    }
//}
