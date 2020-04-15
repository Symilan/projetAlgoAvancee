package visual;

import model.Polygon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYPolygonAnnotation;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.Layer;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.Stroke;
import java.awt.Color;
import java.util.ArrayList;

public class Drawing extends ApplicationFrame {

    private Polygon polygon;

    public Drawing(String title, Polygon polygon) {
        super(title);
        this.polygon=polygon;
        JPanel drawPanel = createPanel();
        drawPanel.setPreferredSize(new java.awt.Dimension(700,350));
        setContentPane(drawPanel);
    }

    public XYDataset createRopeDataset()
    {
        DefaultXYDataset data = new DefaultXYDataset();
        ArrayList<double[][]> list = polygon.ropesToList();
        for (double[][] item : list)
        {
            data.addSeries(item.toString(),item);
        }
        return data;
    }



    public JFreeChart createChart(XYDataset dataset)
    {
        JFreeChart chart = ChartFactory.createXYLineChart("Ropes","X","Y", dataset, PlotOrientation.VERTICAL,false,false,false);

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setDomainPannable(true);
        plot.setRangePannable(true);
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();

        XYPolygonAnnotation a = new XYPolygonAnnotation(polygon.toList(), null, null, new Color(200, 200, 255, 100));
        a.setToolTipText("Polygon");
        renderer.addAnnotation(a, Layer.BACKGROUND);
        return chart;
    }

    public JPanel createPanel()
    {
        JFreeChart chart = createChart(createRopeDataset());
        ChartPanel panel = new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
        return panel;
    }

    public static void draw(Polygon polygon) {
        Drawing drawing = new Drawing("Polygon",polygon);
        drawing.pack();
        RefineryUtilities.centerFrameOnScreen(drawing);
        drawing.setVisible(true);
    }
}
