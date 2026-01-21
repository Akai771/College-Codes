package DS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

class EditorState {
    private String content;
    
    public EditorState(String content) {
        this.content = new String(content); // Deep copy
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
    public int linearSearch(String text, String target) {
        if (text == null || target == null || target.isEmpty()) {
            return -1;
        }
        
        int textLen = text.length();
        int targetLen = target.length();
        
        for (int i = 0; i <= textLen - targetLen; i++) {
            boolean found = true;
            for (int j = 0; j < targetLen; j++) {
                if (text.charAt(i + j) != target.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        return -1;
    }
    
    public String replaceAll(String text, String target, String replacement) {
        if (text == null || target == null || target.isEmpty()) {
            return text;
        }
        
        StringBuilder result = new StringBuilder();
        int lastIndex = 0;
        
        while (lastIndex < text.length()) {
            int index = linearSearch(text.substring(lastIndex), target);
            if (index != -1) {
                result.append(text.substring(lastIndex, lastIndex + index));
                result.append(replacement);
                lastIndex += index + target.length();
            } else {
                result.append(text.substring(lastIndex));
                break;
            }
        }
        return result.toString();
    }
}

public class TextEditor extends JFrame {
    
    private JTextArea textArea;
    private Stack<EditorState> undoStack;  // Stack for undo functionality
    private Stack<EditorState> redoStack;  // Stack for redo functionality
    private TextAnalyzer analyzer;
    private SearchEngine searchEngine;
    
    private JButton undoBtn, redoBtn, findBtn, replaceBtn, wordFreqBtn, clearBtn;
    private JLabel statusLabel;
    
    public TextEditor() {
        // Initialize data structures
        undoStack = new Stack<>();
        redoStack = new Stack<>();
        analyzer = new TextAnalyzer();
        searchEngine = new SearchEngine();
        
        setupUI();
        setupListeners();
    }

    private void setupUI() {
        setTitle("Notepad--");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        buttonPanel.setBackground(new Color(240, 240, 240));
        
        undoBtn = createButton("Undo", new Color(100, 150, 255));
        redoBtn = createButton("Redo", new Color(100, 150, 255));
        findBtn = createButton("Find", new Color(50, 200, 100));
        replaceBtn = createButton("Replace", new Color(50, 200, 100));
        wordFreqBtn = createButton("Word Frequency", new Color(255, 150, 50));
        clearBtn = createButton("Clear", new Color(255, 100, 100));
        
        buttonPanel.add(undoBtn);
        buttonPanel.add(redoBtn);
        buttonPanel.add(findBtn);
        buttonPanel.add(replaceBtn);
        buttonPanel.add(wordFreqBtn);
        buttonPanel.add(clearBtn);
        statusLabel = new JLabel(" Ready | Stack-based Undo/Redo | HashMap Word Analysis | Linear Search");
        statusLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        statusLabel.setFont(new Font("Roboto", Font.PLAIN, 11));
        
        // Layout
        setLayout(new BorderLayout(5, 5));
        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);
    }
    
    private JButton createButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Roboto", Font.BOLD, 12));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    private void setupListeners() {
        // Save state before typing (for undo)
        textArea.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) { }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { }
        });
        
        undoBtn.addActionListener(e -> undo());
        redoBtn.addActionListener(e -> redo());
        findBtn.addActionListener(e -> find());
        replaceBtn.addActionListener(e -> replace());
        wordFreqBtn.addActionListener(e -> showWordFrequency());
        clearBtn.addActionListener(e -> clear());

        textArea.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.isControlDown()) {
                    if (e.getKeyCode() == KeyEvent.VK_Z) {
                        undo();
                    } else if (e.getKeyCode() == KeyEvent.VK_Y) {
                        redo();
                    } else if (e.getKeyCode() == KeyEvent.VK_F) {
                        find();
                    } else if (e.getKeyCode() == KeyEvent.VK_H) {
                        replace();
                    }
                }
            }
        });
    }

    private void saveState() {
        undoStack.push(new EditorState(textArea.getText()));
        redoStack.clear(); // Clear redo when new action is performed
        updateStatus("State saved to undo stack");
    }
    
    private void undo() {
        if (undoStack.isEmpty()) {
            updateStatus("Nothing to undo!");
            return;
        }
        
        redoStack.push(new EditorState(textArea.getText()));
        EditorState state = undoStack.pop();
        textArea.setText(state.getContent());
        updateStatus("Undo performed | Stack size: " + undoStack.size());
    }

    private void redo() {
        if (redoStack.isEmpty()) {
            updateStatus("Nothing to redo!");
            return;
        }
        
        undoStack.push(new EditorState(textArea.getText()));
        EditorState state = redoStack.pop();
        textArea.setText(state.getContent());
        updateStatus("Redo performed | Stack size: " + redoStack.size());
    }

    private void find() {
        String searchText = JOptionPane.showInputDialog(this, "Enter text to find:");
        if (searchText == null || searchText.isEmpty()) return;
        
        String content = textArea.getText();
        int index = searchEngine.linearSearch(content, searchText);
        
        if (index != -1) {
            textArea.setSelectionStart(index);
            textArea.setSelectionEnd(index + searchText.length());
            textArea.requestFocus();
            updateStatus("Found at position " + index + " (Linear Search)");
        } else {
            JOptionPane.showMessageDialog(this, "Text not found!");
            updateStatus("Text not found using Linear Search");
        }
    }
    
    private void replace() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        JTextField findField = new JTextField();
        JTextField replaceField = new JTextField();
        panel.add(new JLabel("Find:"));
        panel.add(findField);
        panel.add(new JLabel("Replace with:"));
        panel.add(replaceField);
        JLabel noteLabel = new JLabel("Note: This is case-sensitive.");
        noteLabel.setForeground(Color.RED);
        panel.add(noteLabel);
        
        int result = JOptionPane.showConfirmDialog(this, panel, "Find and Replace", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String find = findField.getText();
            String replace = replaceField.getText();
            
            if (!find.isEmpty()) {
                saveState();
                String newText = searchEngine.replaceAll(textArea.getText(), find, replace);
                textArea.setText(newText);
                updateStatus("Replaced all occurrences");
            }
        }
    }
    
    private void showWordFrequency() {
        String text = textArea.getText();
        
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Document is empty!");
            return;
        }
        
        // Analyze using HashMap
        HashMap<String, Integer> wordFreq = analyzer.analyzeText(text);
        List<Map.Entry<String, Integer>> topWords = analyzer.getTopWords(wordFreq, 10);
        
        // Build result string
        StringBuilder result = new StringBuilder();
        result.append("📊 WORD FREQUENCY ANALYSIS (HashMap)\n");
        result.append("═══════════════════════════════════\n\n");
        result.append("Total Words: ").append(getTotalWords(wordFreq)).append("\n");
        result.append("Unique Words: ").append(wordFreq.size()).append("\n\n");
        result.append("Top 10 Most Frequent Words:\n");
        result.append("───────────────────────────\n");
        
        int rank = 1;
        for (Map.Entry<String, Integer> entry : topWords) {
            result.append(String.format("%2d. %-15s : %d times\n", rank++, entry.getKey(), entry.getValue()));
        }
        
        JTextArea displayArea = new JTextArea(result.toString(), 20, 40);
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Consolas", Font.PLAIN, 12));
        JOptionPane.showMessageDialog(this, new JScrollPane(displayArea), "Word Frequency Analysis", JOptionPane.INFORMATION_MESSAGE);
        updateStatus("Word frequency analyzed using HashMap");
    }

    private int getTotalWords(HashMap<String, Integer> wordFreq) {
        int total = 0;
        for (int count : wordFreq.values()) {
            total += count;
        }
        return total;
    }

    private void clear() {
        int confirm = JOptionPane.showConfirmDialog(this, "Clear entire document?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            saveState();
            textArea.setText("");
            updateStatus("Document cleared");
        }
    }

    private void updateStatus(String message) {
        statusLabel.setText(" " + message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TextEditor editor = new TextEditor();
            editor.setVisible(true);
        });
    }
}