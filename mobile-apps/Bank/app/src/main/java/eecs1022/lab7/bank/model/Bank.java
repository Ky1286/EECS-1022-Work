package eecs1022.lab7.bank.model;

public class Bank {

    Client[] clients = new Client[0];
    boolean error = false;
    String errorString = "";

    public String getStatus() {
        String result = "Accounts: ";
        if (this.error == true) {
            result = this.errorString;
        } else if (clients.length == 0) {
            result += "{}";
        } else {
            result += "{";
            for (int i = 0; i < clients.length; i++) {
                result += clients[i].getStatus();
                if (i < clients.length - 1) {
                    result += ", ";
                }
            }
            result += "}";
        }
        return result;
    }

    public void increaseSizeClient() {
        Client[] temp = new Client[this.clients.length + 1];
        for (int i = 0; i < this.clients.length; i++) {
            temp[i] = this.clients[i];
        }
        this.clients = temp;
    }

    public String[] getStatement(String name) {
        String[] temp = null;
        boolean allowed = false;
        if (clients.length == 0) {
            this.error = true;
            this.errorString = "Error: From-Account " + name + " does not exist";
        } else if (clients.length > 0) {
            for (int i = 0; i < this.clients.length; i++) {
                if (this.clients[i].name.equals(name)) {
                    allowed = true;
                    break;
                }
            }
        }
        if (allowed == true) {
            temp = new String[1];
            for (int i = 0; i < this.clients.length; i++) {
                if (this.clients[i].name.equals(name)) {
                    if (this.clients[i].getStatement().length == 0) {
                        temp[0] = this.clients[i].getStatus();
                    } else {
                        temp = this.clients[i].getStatement();
                    }
                }
            }
        } else {
            this.error = true;
            this.errorString = "Error: From-Account " + name + " does not exist";
        }
        return temp;
    }

    public void deposit(String name, double v) {
        if (clients.length == 0) {
            this.error = true;
            this.errorString = "Error: To-Account " + name + " does not exist";
        } else if (v <= 0) {
            this.error = true;
            this.errorString = "Error: Non-Positive Amount";
        } else {
            for (int i = 0; i < this.clients.length; i++) {
                if (this.clients[i].name.equals(name)) {
                    this.clients[i].getStatus();
                    this.clients[i].deposit(v);
                    break;
                }
            }
        }
    }

    public void withdraw(String name, double v) {
        if (clients.length == 0) {
            this.error = true;
            this.errorString = "Error: From-Account " + name + " does not exist";
        } else if (v <= 0){
            this.error = true;
            this.errorString = "Error: Non-Positive Amount";
        } else {
            for (int i = 0; i < this.clients.length; i++) {
                if (this.clients[i].name.equals(name)) {
                    if (this.clients[i].bal - v < 0) {
                        this.error = true;
                        this.errorString = "Error: Amount too large to withdraw";
                        break;
                    } else {
                        this.error = false;
                        this.clients[i].withdraw(v);
                    }
                }
            }
        }
    }

    public void transfer(String name1, String name2, double v) {
        boolean allowed = false;
        boolean allowed2 = false;
        if (clients.length == 0) {
            this.error = true;
            this.errorString = "Error: From-Account " + name1 + " does not exist";
        } else if (this.clients.length > 0) {
            for (int i = 0; i < this.clients.length; i++) {
                if (this.clients[i].name.equals(name1)) {
                    allowed = true;
                    break;
                }
            }
        }
        if (this.clients.length > 0) {
            for (int i = 0; i < this.clients.length; i++) {
                if (this.clients[i].name.equals(name2)) {
                    allowed2 = true;
                    break;
                }
            }
        }
        if (allowed == true && allowed2 == true && v > 0) {
            for (int i = 0; i < this.clients.length; i++) {
                if (this.clients[i].name.equals(name1)) {
                    if (this.clients[i].bal - v < 0) {
                        this.error = true;
                        this.errorString = "Error: Amount too large to transfer";
                        break;
                    } else if (this.clients[i].bal - v >= 0) {
                        this.clients[i].withdraw(v);
                        for (int j = 0; j < this.clients.length; j++) {
                            if (this.clients[j].name.equals(name2)) {
                                this.clients[j].deposit(v);
                                break;
                            }
                        }
                        this.error = false;
                        break;
                    }
                }
            }
        }
        if (allowed == false) {
            this.error = true;
            this.errorString = "Error: From-Account " + name1 + " does not exist";
        } else if (allowed2 == false) {
            this.error = true;
            this.errorString = "Error: To-Account " + name2 + " does not exist";
        } else if (v <= 0) {
            this.error = true;
            this.errorString = "Error: Non-Positive Amount";
        }
    }

    public void addClient(String name, double v) {
        boolean allowed = true;
        if (v <= 0) {
            this.error = true;
            this.errorString = "Error: Non-Positive Initial Balance";
            allowed = false;
        } else if (this.clients.length > 0) {
            for (int i = 0; i < this.clients.length; i++) {
                if (this.clients[i].name.equals(name)) {
                    this.error = true;
                    this.errorString = "Error: Client " + name +" already exists";
                    allowed = false;
                    break;
                }
            }
        }
        if (this.clients.length == 6){
            this.error = true;
            this.errorString = "Error: Maximum Number of Accounts Reached";
            allowed = false;
        }
        if (allowed == true) {
            increaseSizeClient();
            Client temp = new Client(name, v);
            for (int i = 0; i < this.clients.length; i++) {
                if (this.clients[i] == null) {
                    this.clients[i] = temp;
                }
            }
            this.error = false;
        }
    }
}
