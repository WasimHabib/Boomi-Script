import java.lang.management.*
import com.sun.tools.attach.*

def getOwnPid() {
  name = ManagementFactory.runtimeMXBean.name
  name[0..<name.indexOf('@')]
}

def heapHisto(vmid) {
  vm = VirtualMachine.attach(vmid)
  histo = vm.heapHisto().text
  vm.detach()
  histo
}

heapHisto(getOwnPid())
