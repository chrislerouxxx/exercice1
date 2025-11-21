# Tableau de bord de progression des tâches (Ionic + React)

## Objectif
Proposer une vue claire de l'état d'avancement des tâches pour une application mobile construite avec Ionic React.

## Maquette fonctionnelle
- **En-tête** : titre "Tableau de bord" + bouton de rafraîchissement.
- **Cartes synthétiques** :
  - Total des tâches, tâches terminées, en cours, en attente.
  - Indicateur de progression (barre ou cercle) basé sur le ratio terminé/total.
- **Liste filtrable** :
  - Segments Ionic (`<IonSegment>`) pour filtrer par statut (Toutes, En cours, Terminées, Bloquées).
  - Chaque item (`<IonItem>`): titre, badge de statut, priorité (couleur), date limite.
- **Timeline/Agenda** : mini calendrier ou timeline affichant les échéances proches.
- **Recherche et tri** : barre de recherche (`<IonSearchbar>`), tri par date, priorité, statut.
- **Actions rapides** : bouton flottant (`<IonFab>`) pour ajouter une tâche.

## Structure React/Ionic suggérée
- `pages/Dashboard.tsx` : page principale affichant les cartes, filtres, et liste.
- `components/StatsCards.tsx` : cartes de synthèse (props: totals, completionRate).
- `components/TaskList.tsx` : liste filtrable avec callbacks `onToggleStatus`, `onFilterChange`.
- `components/ProgressRing.tsx` : indicateur circulaire utilisant `conic-gradient` ou SVG.
- `components/UpcomingDeadlines.tsx` : échéances imminentes (calendrier compact).

## Modèle de données minimal
```ts
export type TaskStatus = 'todo' | 'in-progress' | 'done' | 'blocked';

export interface Task {
  id: string;
  title: string;
  description?: string;
  status: TaskStatus;
  priority: 'low' | 'medium' | 'high';
  dueDate?: string; // ISO
  updatedAt: string; // ISO
}
```

## Hooks / logique
- `useTasks` : charge les tâches, expose `tasks`, `isLoading`, `error`, `refresh`, `updateTask`.
- `useStats` : dérive les métriques (total, en cours, terminées, ratio de complétion).

## Palette et UX
- Utiliser la palette Ionic par défaut avec accents :
  - `--ion-color-primary`: bleu (#3880ff) pour actions principales.
  - `--ion-color-success`: vert pour tâches terminées.
  - `--ion-color-warning`: orange pour en cours.
  - `--ion-color-danger`: rouge pour bloquées.
- Prévoir un thème sombre via `prefers-color-scheme`.

## États vides et erreurs
- État vide : illustration + CTA "Créer ma première tâche".
- Erreur réseau : `IonToast` ou `IonAlert` avec bouton de rechargement.

## Tests rapides
- Tester le filtrage par statut et la recherche simultanément.
- Vérifier la cohérence des stats après changement de statut.
- Contrôler l'accessibilité : labels pour boutons, contraste des badges.

## Étapes de mise en œuvre
1. Créer les composants de présentation (`StatsCards`, `ProgressRing`, `TaskList`).
2. Ajouter les hooks `useTasks` et `useStats` avec données mockées puis API réelle.
3. Intégrer la page `Dashboard.tsx` et câbler filtres + actions.
4. Tester sur simulateur mobile (Chrome devtools / `ionic serve`).
