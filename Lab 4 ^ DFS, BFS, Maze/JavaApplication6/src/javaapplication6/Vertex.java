package javaapplication6;

public class Vertex  {

    protected int Data;
    protected Label label;
    protected Link Links;

    public Vertex(int Data) {
        this.Data = Data;
        label = new Label();
        Links = new Link();
    }

    public void CreateEdge(Vertex Vert1) {
        Links.Add(Vert1);
    }

    public String ShowLabel() {
        return this.label.ShowLabel();
    }

    public int RevealNext() {
        return Links.RevealNext();
    }

    public int Next() {
        return Links.Next();
    }

    public int LinkTop() {
        return Links.top;
    }

    public int LinkFind(int index) {
        return Links.Index(index);
    }

    public void SetVisited() {
        label.Visit();
    }

    public void ClearLabel() {
        label.ClearLabels();
    }

    public void MoveRange() {
        Links.BackwardRange();
    }
    
}
