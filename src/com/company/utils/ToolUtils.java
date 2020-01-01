package com.company.utils;

import com.company.tools.BaseTool;
import com.company.tools.PencilTool;

import java.util.Hashtable;

public abstract class ToolUtils {
    private static Hashtable<String, BaseTool> toolsTable;
    private static BaseTool selectedTool;

    static {
        toolsTable = new Hashtable<>();
        toolsTable.put("pencil", new PencilTool());
    }

    public static BaseTool getTool(String toolName) {
        return toolsTable.get(toolName);
    }

    public static BaseTool getSelectedTool() {
        return selectedTool;
    }

    public static void setSelectedTool(String key) {
        BaseTool tool = toolsTable.get(key);
        if(tool == null) {
            throw new IllegalArgumentException("Can not find a tool with name " + key + ".");
        }
        selectedTool = tool;
    }
}
