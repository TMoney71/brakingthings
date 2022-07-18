package com.example.brakingthings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.esri.arcgisruntime.ArcGISRuntimeEnvironment
import com.esri.arcgisruntime.geometry.Point
import com.esri.arcgisruntime.geometry.SpatialReferences

import com.esri.arcgisruntime.mapping.ArcGISMap
import com.esri.arcgisruntime.mapping.BasemapStyle
import com.esri.arcgisruntime.mapping.Viewpoint
import com.esri.arcgisruntime.mapping.view.Graphic
import com.esri.arcgisruntime.mapping.view.GraphicsOverlay
import com.esri.arcgisruntime.mapping.view.MapView
import com.esri.arcgisruntime.symbology.SimpleLineSymbol
import com.esri.arcgisruntime.symbology.SimpleMarkerSymbol

import com.example.brakingthings.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private val activityMainBinding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    private val mapView: MapView by lazy {activityMainBinding.mapView}

    private val pointList = mutableListOf<Point>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityMainBinding.root)

        setApiKeyForApp()

        setupMap()

        addGraphics()
    }

    override fun onPause() {
        mapView.pause()
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        mapView.resume()
    }

    override fun onDestroy() {
        mapView.dispose()
        super.onDestroy()
    }

    private fun setupMap() {

        val map = ArcGISMap(BasemapStyle.ARCGIS_TOPOGRAPHIC)

        mapView.map = map

        mapView.setViewpoint(Viewpoint(34.0270, -118.8050, 72000.0))
    }

    private fun setApiKeyForApp(){

        ArcGISRuntimeEnvironment.setApiKey("AAPK427a3a080416435ca86df3ed3b877e4aBoRhKHpRxvkD_S7wukswx3LPo56iD1UTK5pDJuNUcGPl_mAyIV7lipKv4EfGBUBy")

    }

    private  fun addGraphics() {
        val graphicsOverlay = GraphicsOverlay()
        mapView.graphicsOverlays.add(graphicsOverlay)

        pointList.add(Point(111.78220388310245, 43.81849614954874, SpatialReferences.getWgs84()))
        pointList.add(Point(48.9201, 122.3427, SpatialReferences.getWgs84()))
        pointList.add(Point(-118.8065, 34.0005, SpatialReferences.getWgs84()))
//        pointList.add(Point(-118.8065, 34.0005, SpatialReferences.getWgs84()))
//        pointList.add(Point(-118.8065, 34.0005, SpatialReferences.getWgs84()))
//        pointList.add(Point(-118.8065, 34.0005, SpatialReferences.getWgs84()))
//        pointList.add(Point(-118.8065, 34.0005, SpatialReferences.getWgs84()))
//        pointList.add(Point(-118.8065, 34.0005, SpatialReferences.getWgs84()))
//        pointList.add(Point(-118.8065, 34.0005, SpatialReferences.getWgs84()))
//        pointList.add(Point(-118.8065, 34.0005, SpatialReferences.getWgs84()))
//        pointList.add(Point(-118.8065, 34.0005, SpatialReferences.getWgs84()))
//        pointList.add(Point(-118.8065, 34.0005, SpatialReferences.getWgs84()))
//        pointList.add(Point(-118.8065, 34.0005, SpatialReferences.getWgs84()))
//        pointList.add(Point(-118.8065, 34.0005, SpatialReferences.getWgs84()))


        // create an opaque orange (0xFFFF5733) point symbol with a blue (0xFF0063FF) outline symbol
        val simpleMarkerSymbol = SimpleMarkerSymbol(SimpleMarkerSymbol.Style.CIRCLE, -0xa8cd, 10f)

        val blueOutlineSymbol = SimpleLineSymbol(SimpleLineSymbol.Style.SOLID, -0xff9c01, 2f)
        simpleMarkerSymbol.outline = blueOutlineSymbol

        pointList.forEach { point ->
            val graphic = Graphic(point, simpleMarkerSymbol)
            graphicsOverlay.graphics.add(graphic)
        }

    }

}


