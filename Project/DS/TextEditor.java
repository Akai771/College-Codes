import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List; 

class EditorState {
    private String content;

    public EditorState(String content) {
        this.content = new String(content);
    }

    public String getContent() {
        return content;
    }
}

class TextAnalyzer {
    public HashMap<String, Integer> analyzeText(String text) {
        HashMap<String, Integer> wordFrequency = new HashMap<>();

        if (text == null || text.isEmpty()) {
            return wordFrequency;
        }

        String[] words = text.toLowerCase()
                .replaceAll("[^a-zA-Z0-9\\s]", " ")
                .split("\\s+");

        for (String word : words) {
            if (!word.isEmpty()) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }
        return wordFrequency;
    }

    public List<Map.Entry<String, Integer>> getTopWords(HashMap<String, Integer> wordFrequency, int n) {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordFrequency.entrySet());
        entries.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        return entries.subList(0, Math.min(n, entries.size()));
    }
}

class SearchEngine {
    public int linearSearch(String text, String target, boolean caseSensitive) {
        if (text == null || target == null || target.isEmpty()) {
            return -1;
        }

        String searchText = caseSensitive ? text : text.toLowerCase();
        String searchTarget = caseSensitive ? target : target.toLowerCase();

        for (int i = 0; i <= searchText.length() - searchTarget.length(); i++) {
            boolean found = true;
            for (int j = 0; j < searchTarget.length(); j++) {
                if (searchText.charAt(i + j) != searchTarget.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) return i;
        }
        return -1;
    }

    public int replaceAll(JTextArea textArea, String target, String replacement, boolean caseSensitive) {
        if (target == null || target.isEmpty()) return 0;

        String text = textArea.getText();
        int count = 0;
        StringBuilder result = new StringBuilder();
        int lastIndex = 0;

        while (lastIndex < text.length()) {
            int index = linearSearch(text.substring(lastIndex), target, caseSensitive);
            if (index != -1) {
                result.append(text, lastIndex, lastIndex + index);
                result.append(replacement);
                lastIndex += index + target.length();
                count++;
            } else {
                result.append(text.substring(lastIndex));
                break;
            }
        }

        textArea.setText(result.toString());
        return count;
    }
}

public class TextEditor extends JFrame {
    private static final int MAX_UNDO_SIZE = 50;

    private JTextArea textArea;
    private Deque<EditorState> undoStack;
    private Deque<EditorState> redoStack;
    private boolean isDirty = false;
    private TextAnalyzer analyzer;
    private SearchEngine searchEngine;
    private boolean isUpdatingFromHistory = false;

    private JLabel statusLabel;
    private JButton undoBtn, redoBtn;
    private String lastSearchTerm = "";
    private boolean lastCaseSensitive = false;
    private boolean isDarkMode = false;
    private String currentFilePath = null;
    private javax.swing.Timer autoSaveTimer;
    private List<Integer> highlightPositions = new ArrayList<>();

    public TextEditor() {
        undoStack = new ArrayDeque<>();
        redoStack = new ArrayDeque<>();
        analyzer = new TextAnalyzer();
        searchEngine = new SearchEngine();

        setupUI();
        setupListeners();
        setupKeyboardShortcuts();
        setupAutoSave();
        setupWindowListener();
    }

    private void setupUI() {
        setTitle("Smart Text Editor - DSA Based");
        setSize(1000, 700);
        setLocationRelativeTo(null);

        // Create menu bar
        JMenuBar menuBar = createMenuBar();
        setJMenuBar(menuBar);

        textArea = new JTextArea();
        textArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(textArea);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));

        undoBtn = createButton("Undo (Ctrl+Z)", new Color(100, 150, 255));
        redoBtn = createButton("Redo (Ctrl+Y)", new Color(100, 150, 255));
        JButton findBtn = createButton("Find (Ctrl+F)", new Color(50, 200, 100));
        JButton findNextBtn = createButton("Find Next (F3)", new Color(50, 200, 100));
        JButton clearHighlightBtn = createButton("Clear Highlights", new Color(200, 100, 100));
        JButton replaceBtn = createButton("Replace (Ctrl+H)", new Color(200, 100, 50));
        JButton wordFreqBtn = createButton("Word Frequency", new Color(255, 150, 50));
        JButton countBtn = createButton("Count (Ctrl+Shift+W)", new Color(150, 150, 255));
        JButton fontBtn = createButton("Font Settings", new Color(180, 100, 180));
        JButton themeBtn = createButton("Toggle Theme", new Color(100, 100, 100));
        JButton saveBtn = createButton("Save (Ctrl+S)", new Color(100, 200, 100));
        JButton loadBtn = createButton("Load (Ctrl+O)", new Color(100, 200, 150));
        JButton clearBtn = createButton("Clear", new Color(255, 100, 100));

        buttonPanel.add(undoBtn);
        buttonPanel.add(redoBtn);
        buttonPanel.add(findBtn);
        buttonPanel.add(findNextBtn);
        buttonPanel.add(clearHighlightBtn);
        buttonPanel.add(replaceBtn);
        buttonPanel.add(wordFreqBtn);
        buttonPanel.add(countBtn);
        buttonPanel.add(fontBtn);
        buttonPanel.add(themeBtn);
        buttonPanel.add(saveBtn);
        buttonPanel.add(loadBtn);
        buttonPanel.add(clearBtn);

        statusLabel = new JLabel(" Ready | Stack | HashMap | Linear Search");
        statusLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

        // Button actions
        undoBtn.addActionListener(e -> undo());
        redoBtn.addActionListener(e -> redo());
        findBtn.addActionListener(e -> find());
        findNextBtn.addActionListener(e -> findNext());
        clearHighlightBtn.addActionListener(e -> clearHighlights());
        replaceBtn.addActionListener(e -> replace());
        wordFreqBtn.addActionListener(e -> showWordFrequency());
        countBtn.addActionListener(e -> showCount());
        fontBtn.addActionListener(e -> showFontSettings());
        themeBtn.addActionListener(e -> toggleTheme());
        saveBtn.addActionListener(e -> saveFile());
        loadBtn.addActionListener(e -> loadFile());
        clearBtn.addActionListener(e -> clear());

        updateButtonStates();
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem loadItem = new JMenuItem("Load");
        JMenuItem exitItem = new JMenuItem("Exit");
        saveItem.addActionListener(e -> saveFile());
        loadItem.addActionListener(e -> loadFile());
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(saveItem);
        fileMenu.add(loadItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        JMenu editMenu = new JMenu("Edit");
        JMenuItem undoItem = new JMenuItem("Undo");
        JMenuItem redoItem = new JMenuItem("Redo");
        undoItem.addActionListener(e -> undo());
        redoItem.addActionListener(e -> redo());
        editMenu.add(undoItem);
        editMenu.add(redoItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        return menuBar;
    }

    private JButton createButton(String text, Color color) {
        JButton btn = new JButton(text);
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        return btn;
    }

    private void setupListeners() {
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                if (!isUpdatingFromHistory) {
                    saveState();
                    updateStatusBar();
                }
            }
            public void removeUpdate(DocumentEvent e) {
                if (!isUpdatingFromHistory) {
                    saveState();
                    updateStatusBar();
                }
            }
            public void changedUpdate(DocumentEvent e) {
                if (!isUpdatingFromHistory) updateStatusBar();
            }
        });
    }

    private void setupKeyboardShortcuts() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(e -> {
            if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Z && e.getID() == KeyEvent.KEY_PRESSED) {
                undo();
                return true;
            }
            if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Y && e.getID() == KeyEvent.KEY_PRESSED) {
                redo();
                return true;
            }
            if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_F && e.getID() == KeyEvent.KEY_PRESSED) {
                find();
                return true;
            }
            if (e.getKeyCode() == KeyEvent.VK_F3 && e.getID() == KeyEvent.KEY_PRESSED) {
                findNext();
                return true;
            }
            if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_H && e.getID() == KeyEvent.KEY_PRESSED) {
                replace();
                return true;
            }
            if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S && e.getID() == KeyEvent.KEY_PRESSED) {
                saveFile();
                return true;
            }
            if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_O && e.getID() == KeyEvent.KEY_PRESSED) {
                loadFile();
                return true;
            }
            if (e.isControlDown() && e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_W && e.getID() == KeyEvent.KEY_PRESSED) {
                showCount();
                return true;
            }
            return false;
        });
    }

    private void setupAutoSave() {
        autoSaveTimer = new javax.swing.Timer(30000, e -> {
            if (currentFilePath != null && isDirty) {
                saveFileQuietly();
            }
        });
        autoSaveTimer.start();
    }

    private void setupWindowListener() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (isDirty) {
                    int result = JOptionPane.showConfirmDialog(
                        TextEditor.this,
                        "You have unsaved changes. Do you want to save before exiting?",
                        "Unsaved Changes",
                        JOptionPane.YES_NO_CANCEL_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        saveFile();
                        dispose();
                    } else if (result == JOptionPane.NO_OPTION) {
                        dispose();
                    }
                } else {
                    dispose();
                }
            }
        });
    }

    private void saveFileQuietly() {
        if (currentFilePath == null) return;
        try (FileWriter writer = new FileWriter(currentFilePath)) {
            writer.write(textArea.getText());
            isDirty = false;
            setTitle("Smart Text Editor - DSA Based [" + currentFilePath + "]");
        } catch (IOException e) {
            // Silent fail for auto-save
        }
    }

    private void saveState() {
        if (undoStack.size() >= MAX_UNDO_SIZE) {
            undoStack.removeLast();
        }
        undoStack.push(new EditorState(textArea.getText()));
        redoStack.clear();
        isDirty = true;
        updateButtonStates();
    }

    private void updateStatusBar() {
        String text = textArea.getText();
        int chars = text.length();
        int words = text.trim().isEmpty() ? 0 : text.trim().split("\\s+").length;
        int lines = text.isEmpty() ? 0 : text.split("\n", -1).length;

        String statusText = String.format(" Characters: %d | Words: %d | Lines: %d | Undo: %d | Redo: %d",
                chars, words, lines, undoStack.size(), redoStack.size());
        statusLabel.setText(statusText);
    }

    private void updateButtonStates() {
        undoBtn.setEnabled(!undoStack.isEmpty());
        redoBtn.setEnabled(!redoStack.isEmpty());
        updateStatusBar();
    }

    private void undo() {
        if (!undoStack.isEmpty()) {
            isUpdatingFromHistory = true;
            redoStack.push(new EditorState(textArea.getText()));
            textArea.setText(undoStack.pop().getContent());
            isDirty = true;
            isUpdatingFromHistory = false;
            updateButtonStates();
        }
    }

    private void redo() {
        if (!redoStack.isEmpty()) {
            isUpdatingFromHistory = true;
            undoStack.push(new EditorState(textArea.getText()));
            textArea.setText(redoStack.pop().getContent());
            isDirty = true;
            isUpdatingFromHistory = false;
            updateButtonStates();
        }
    }

    private void find() {
        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
        JTextField searchField = new JTextField(lastSearchTerm, 20);
        JCheckBox caseCheck = new JCheckBox("Case Sensitive", lastCaseSensitive);

        panel.add(new JLabel("Find what:"));
        panel.add(searchField);
        panel.add(caseCheck);
        panel.add(new JLabel(""));  // Empty cell for grid balance

        int result = JOptionPane.showConfirmDialog(
                this, panel, "Find", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            lastSearchTerm = searchField.getText();
            lastCaseSensitive = caseCheck.isSelected();
            highlightAllMatches();
            findNext();
        }
    }

    private void highlightAllMatches() {
        clearHighlights();
        
        if (lastSearchTerm == null || lastSearchTerm.isEmpty()) {
            return;
        }

        String text = textArea.getText();
        String searchText = lastCaseSensitive ? text : text.toLowerCase();
        String searchTarget = lastCaseSensitive ? lastSearchTerm : lastSearchTerm.toLowerCase();
        
        highlightPositions.clear();
        int index = 0;
        
        while (index <= searchText.length() - searchTarget.length()) {
            int found = searchEngine.linearSearch(searchText.substring(index), searchTarget, true);
            if (found != -1) {
                int actualPos = index + found;
                highlightPositions.add(actualPos);
                
                try {
                    textArea.getHighlighter().addHighlight(actualPos, actualPos + lastSearchTerm.length(),
                            new DefaultHighlighter.DefaultHighlightPainter(new Color(255, 255, 0)));
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }
                
                index = actualPos + lastSearchTerm.length();
            } else {
                break;
            }
        }
    }

    private void clearHighlights() {
        textArea.getHighlighter().removeAllHighlights();
        highlightPositions.clear();
    }

    private void findNext() {
        if (lastSearchTerm == null || lastSearchTerm.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please use Find first to set a search term");
            return;
        }

        String text = textArea.getText();
        int startPos = textArea.getSelectionEnd();
        
        // If no selection or at the beginning, start from 0
        if (startPos <= 0) {
            startPos = 0;
        }

        // Search from current position
        int index = searchEngine.linearSearch(text.substring(startPos), lastSearchTerm, lastCaseSensitive);
        
        if (index != -1) {
            int foundPos = startPos + index;
            textArea.select(foundPos, foundPos + lastSearchTerm.length());
            textArea.requestFocus();
        } else if (startPos > 0) {
            // Wrap around to beginning
            index = searchEngine.linearSearch(text, lastSearchTerm, lastCaseSensitive);
            if (index != -1) {
                textArea.select(index, index + lastSearchTerm.length());
                textArea.requestFocus();
                JOptionPane.showMessageDialog(this, "Wrapped around to beginning");
            } else {
                JOptionPane.showMessageDialog(this, "Text \"" + lastSearchTerm + "\" not found");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Text \"" + lastSearchTerm + "\" not found");
        }
    }

    private void replace() {
        JPanel panel = new JPanel(new GridLayout(3, 2));
        JTextField findField = new JTextField(lastSearchTerm, 20);
        JTextField replaceField = new JTextField(20);
        JCheckBox caseSensitiveCheckBox = new JCheckBox("Case Sensitive", lastCaseSensitive);

        panel.add(new JLabel("Find:"));
        panel.add(findField);
        panel.add(new JLabel("Replace with:"));
        panel.add(replaceField);
        panel.add(caseSensitiveCheckBox);
        panel.add(new JLabel(""));

        int result = JOptionPane.showConfirmDialog(this, panel, "Find & Replace", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String findText = findField.getText();
            String replaceText = replaceField.getText();
            lastSearchTerm = findText;
            lastCaseSensitive = caseSensitiveCheckBox.isSelected();

            if (!findText.isEmpty()) {
                saveState();
                int count = searchEngine.replaceAll(textArea, findText, replaceText, lastCaseSensitive);
                clearHighlights();
                JOptionPane.showMessageDialog(this, "Replaced " + count + " occurrences");
            }
        }
    }

    private void showWordFrequency() {
        HashMap<String, Integer> map = analyzer.analyzeText(textArea.getText());
        List<Map.Entry<String, Integer>> topWords = analyzer.getTopWords(map, 20);

        StringBuilder sb = new StringBuilder();
        sb.append("Top Words (Total Unique: ").append(map.size()).append(")\n\n");
        for (Map.Entry<String, Integer> entry : topWords) {
            sb.append(String.format("%-20s : %d\n", entry.getKey(), entry.getValue()));
        }

        JTextArea displayArea = new JTextArea(sb.toString());
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setPreferredSize(new Dimension(400, 400));

        JOptionPane.showMessageDialog(this, scrollPane, "Word Frequency Analysis", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showCount() {
        String text = textArea.getText();
        int chars = text.length();
        int words = text.trim().isEmpty() ? 0 : text.trim().split("\\s+").length;
        int lines = text.isEmpty() ? 0 : text.split("\n").length;

        JOptionPane.showMessageDialog(this,
                "Characters: " + chars + "\nWords: " + words + "\nLines: " + lines,
                "Document Count",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void showFontSettings() {
        JPanel panel = new JPanel(new GridLayout(2, 2));
        String[] fonts = {"Consolas", "Arial", "Courier New", "Monospaced"};
        JComboBox<String> fontCombo = new JComboBox<>(fonts);
        JSpinner sizeSpinner = new JSpinner(new SpinnerNumberModel(14, 8, 24, 1));

        panel.add(new JLabel("Font:"));
        panel.add(fontCombo);
        panel.add(new JLabel("Size:"));
        panel.add(sizeSpinner);

        int result = JOptionPane.showConfirmDialog(this, panel, "Font Settings", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String selectedFont = (String) fontCombo.getSelectedItem();
            int size = (Integer) sizeSpinner.getValue();
            textArea.setFont(new Font(selectedFont, Font.PLAIN, size));
        }
    }

    private void toggleTheme() {
        isDarkMode = !isDarkMode;
        if (isDarkMode) {
            textArea.setBackground(new Color(30, 30, 30));
            textArea.setForeground(new Color(200, 200, 200));
            textArea.setCaretColor(new Color(200, 200, 200));
            getContentPane().setBackground(new Color(40, 40, 40));
        } else {
            textArea.setBackground(Color.WHITE);
            textArea.setForeground(Color.BLACK);
            textArea.setCaretColor(Color.BLACK);
            getContentPane().setBackground(UIManager.getColor("Panel.background"));
        }
    }

    private void saveFile() {
        if (currentFilePath == null) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                currentFilePath = fileChooser.getSelectedFile().getAbsolutePath();
            } else {
                return;
            }
        }

        try (FileWriter writer = new FileWriter(currentFilePath)) {
            writer.write(textArea.getText());
            isDirty = false;
            setTitle("Smart Text Editor - DSA Based [" + currentFilePath + "]");
            JOptionPane.showMessageDialog(this, "File saved successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + e.getMessage());
        }
    }

    private void loadFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                currentFilePath = file.getAbsolutePath();
                StringBuilder content = new StringBuilder();
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    boolean firstLine = true;
                    while ((line = reader.readLine()) != null) {
                        if (!firstLine) {
                            content.append("\n");
                        }
                        content.append(line);
                        firstLine = false;
                    }
                }
                isUpdatingFromHistory = true;
                textArea.setText(content.toString());
                isUpdatingFromHistory = false;
                undoStack.clear();
                redoStack.clear();
                isDirty = false;
                setTitle("Smart Text Editor - DSA Based [" + currentFilePath + "]");
                updateButtonStates();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error loading file: " + e.getMessage());
            }
        }
    }

    private void clear() {
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to clear all text?");
        if (result == JOptionPane.YES_OPTION) {
            saveState();
            textArea.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TextEditor().setVisible(true));
    }
}