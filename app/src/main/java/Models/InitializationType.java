package Models;

/**
 * Created by Jeremy on 7/3/2018.
 */

public class InitializationType {
    private String typeName;
    private String typeDesc;
    private int typeImgID;

    public InitializationType(String typeName, String typeDesc, int typeImgID) {
        this.typeName = typeName;
        this.typeDesc = typeDesc;
        this.typeImgID = typeImgID;

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

}
