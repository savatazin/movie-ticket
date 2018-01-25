Vagrant.configure("2") do |config|
  config.vm.box = "ubuntu/trusty64"

  config.ssh.username = 'movie'
  config.vm.provider "virtualbox" do |vb|
      vb.memory = "2048" # 3 GiB RAM
      vb.cpus = 1 # Quad core machine

      # Apparently, this improves VBox networking performance.
      vb.customize ["modifyvm", :id, "--natdnshostresolver1", "on"]
      vb.customize ["modifyvm", :id, "--natdnsproxy1", "on"]
  end

  config.vm.provision "shell", path: "vagrant/provision.sh"
end
