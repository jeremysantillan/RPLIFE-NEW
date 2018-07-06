package Models;

/**
 * Created by Jeremy on 7/3/2018.
 */

public class InitializationType {
    private String typeName;
    private String typeDesc;
    private int typeImgID;
    private int colorStart;
    private int colorEnd;

    public InitializationType(String typeName, String typeDesc, int typeImgID, int colorStart, int colorEnd) {
        this.typeName = typeName;
        this.typeDesc = typeDesc;
        this.typeImgID = typeImgID;
        this.colorStart = colorStart;
        this.colorEnd = colorEnd;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public int getTypeImgID() {
        return typeImgID;
    }

    public void setTypeImgID(int typeImgID) {
        this.typeImgID = typeImgID;
    }

    public int getColorStart() {
        return colorStart;
    }

    public void setColorStart(int colorStart) {
        this.colorStart = colorStart;
    }

    public int getColorEnd() {
        return colorEnd;
    }

    public void setColorEnd(int colorEnd) {
        this.colorEnd = colorEnd;
    }
}
