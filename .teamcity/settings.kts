import jetbrains.buildServer.configs.kotlin.*

version = "2025.07"



version = "2021.2"

project {

    buildType(Source)

    val numProjects=1
    val numConfigurationsPerProject=900


    for (i in 0..numProjects) {
        subProject {
            id("subProj_$i")
            name = "subProj $i"

            for (j in 0..numConfigurationsPerProject) {
                buildType {
                    id("subProj_bt_$i" + "_$j")
                    name = "bt $i $j"
                dependencies {
                    snapshot(Source) {
                    reuseBuilds = ReuseBuilds.NO
                }
    }

                }
            }
        }
    }
}

object Source : BuildType({
    name = "source"
})


